---------------------------------------------------------------------------
-- CHARACTER
-- 1
SELECT * FROM characters WHERE IdCharacter = 2;

-- 2
SELECT zones.IdZone, equipments.EquipmName
FROM equipments
INNER JOIN Character_Zone_Equipment ON (equipments.IdEquipm = Character_Zone_Equipment.IdEquipm 
										AND Character_Zone_Equipment.IdCharacter=1)
RIGHT JOIN zones ON (Character_Zone_Equipment.IdZone = zones.IdZone);

-- 3
-- 4

SELECT modifiers.ModName, zones.ZoneName, n.EquipmName, o.EquipmName, n.maxMV, o.maxMV, o.maxMV-n.maxMV
FROM (
    (SELECT Character_Zone_Equipment.IdZone, equipments.EquipmName, MAX(Equipment_Modifier.ModifierValue) as maxMV, modifiers.ModName, modifiers.IdMod
    FROM Character_Zone_Equipment
    INNER JOIN equipments ON (equipments.IdEquipm=Character_Zone_Equipment.IdEquipm AND Character_Zone_Equipment.IdCharacter=6082)
    INNER JOIN Equipment_Modifier ON (Equipment_Modifier.IdEquipm=equipments.IdEquipm)
    RIGHT JOIN modifiers ON (modifiers.IdMod=Equipment_Modifier.IdMod)
    INNER JOIN Equipment_Zone ON (Equipment_Zone.IdEquipm=equipments.IdEquipm)
    GROUP BY Equipment_Zone.IdZone) AS o
)
INNER JOIN 
    (SELECT Equipment_Zone.IdZone, Character_Equipment.IdEquipm, equipments.EquipmName, MAX(Equipment_Modifier.ModifierValue) as maxMV, modifiers.ModName, modifiers.IdMod
    FROM Character_Equipment 
    INNER JOIN equipments ON (equipments.IdEquipm=Character_Equipment.IdEquipm AND Character_Equipment.IdCharacter=6082)
    INNER JOIN Equipment_Modifier ON (Equipment_Modifier.IdEquipm=equipments.IdEquipm)
    RIGHT JOIN modifiers ON (modifiers.IdMod=Equipment_Modifier.IdMod)
    INNER JOIN Equipment_Zone ON (Equipment_Zone.IdEquipm=equipments.IdEquipm)
    WHERE modifiers.IdMod=7
    GROUP BY Equipment_Zone.IdZone) as n
ON (n.IdZone=o.IdZone)
INNER JOIN zones ON (zones.IdZone=o.IdZone)
INNER JOIN Equipment_Modifier ON (Equipment_Modifier.IdEquipm=n.IdEquipm)
RIGHT JOIN modifiers ON (modifiers.IdMod=Equipment_Modifier.IdMod)
GROUP BY modifiers.IdMod, zones.IdZone;


-- 5
SELECT nM.ModName, nM.MSUM AS NEW, oM.MSUM AS OLD, IF(nM.MSUM IS NULL, 0, nM.MSUM)-IF(oM.MSUM IS NULL, 0, oM.MSUM) AS DIFFERENCE
FROM (
(SELECT modifiers.ModName, SUM(Equipment_Modifier.ModifierValue) AS MSUM, modifiers.IdMod
FROM modifiers
LEFT JOIN Equipment_Modifier ON (Equipment_Modifier.IdMod=modifiers.IdMod AND Equipment_Modifier.IdEquipm=2)
GROUP BY modifiers.IdMod) AS nM,
(SELECT modifiers.ModName, SUM(Equipment_Modifier.ModifierValue) as MSUM, modifiers.IdMod
FROM modifiers
LEFT JOIN Equipment_Modifier ON (Equipment_Modifier.IdMod=modifiers.IdMod AND Equipment_Modifier.IdEquipm=3)
GROUP BY modifiers.IdMod) AS oM
)
WHERE nM.IdMod = oM.IdMod;

---------------------------------------------------------------------------
-- CHARACTER FORM
-- 1
INSERT INTO characters (Name, Level, Strength, Intellect, Prudence, Charisma, IdField, IdRace, IdTeam) 
	VALUES ("Valeria Windrunner", 76, 12, 8, 16, 17, 2, 4, 1)

---------------------------------------------------------------------------
-- CHARACTER STATS COMPARISON
-- 1
SELECT p.Charisma, p.Strength, p.Construction, p.Prudence, p.BaseDamage, 
COUNT(oth.Charisma<p.Charisma)/COUNT(oth.IdCharacter)*100 AS OtherPCh, 
COUNT(oth.Strength<p.Strength)/COUNT(oth.IdCharacter)*100 AS OtherPStr, 
COUNT(oth.Construction<p.Construction)/COUNT(oth.IdCharacter)*100 AS OtherPCon, 
COUNT(oth.Prudence<p.Prudence)/COUNT(oth.IdCharacter)*100 AS OtherPPrud, 
COUNT(oth.BaseDamage<p.BaseDamage)/COUNT(oth.IdCharacter)*100 AS OtherPBD
FROM (characters p, characters oth)
WHERE p.IdCharacter = 1;

-- 2
SELECT p.Charisma, p.Strength, p.Construction, p.Prudence, p.BaseDamage, 
oth.Charisma, oth.Strength, oth.Construction, oth.Prudence, oth.BaseDamage, 
IF(p.Charisma<oth.Charisma, "<", IF(p.Charisma=oth.Charisma, "=", ">")) AS CompCharisma,
IF(p.Strength<oth.Strength, "<", IF(p.Strength=oth.Strength, "=", ">")) AS CompStrength,
IF(p.Construction<oth.Construction, "<", IF(p.Construction=oth.Construction, "=", ">")) AS CompConstruction,
IF(p.Prudence<oth.Prudence, "<", IF(p.Prudence=oth.Prudence, "=", ">")) AS CompPrudence,
IF(p.BaseDamage<oth.BaseDamage, "<", IF(p.BaseDamage=oth.BaseDamage, "=", ">")) AS CompBaseDamage
FROM (characters p, characters oth)
WHERE p.IdCharacter = 1 AND oth.IdCharacter = 2;

---------------------------------------------------------------------------
-- GAME HISTORY
-- 1
SELECT RoundSummary.IdRoundSummary, rounds.IdRound, characters.IdCharacter, characters.Name, actions.ActionName, fields.XCoordinate, fields.YCoordinate, RoundSummary.DealtDamage, rolls.Dice, rolls.DiceAmount
FROM RoundSummary
LEFT JOIN rounds ON (rounds.IdRound=RoundSummary.IdRound)
LEFT JOIN characters ON (characters.IdCharacter=RoundSummary.IdCharacter)
LEFT JOIN actions ON (actions.IdAction=RoundSummary.IdAction)
LEFT JOIN fields ON (fields.IdField=RoundSummary.IdTarget)
INNER JOIN rolls ON (rolls.IdRoll=RoundSummary.IdRoll)
GROUP BY RoundSummary.IdRoundSummary
ORDER BY RoundSummary.IdRoundSummary ASC;
---------------------------------------------------------------------------
-- ROLL STATICS
-- 1 TODO
SELECT mmin.Dice, mmin.c, mmin.minda, mmin.minch, mmax.maxda, mmax.maxch
FROM(
(SELECT rolls.Dice, COUNT(rolls.IdRoll) as c, MIN(rolls.DiceAmount) as minda, RoundSummary.IdCharacter as minch
FROM rolls
LEFT JOIN RoundSummary ON (RoundSummary.IdRoll=rolls.IdRoll)
GROUP BY rolls.Dice) as mmin,
(SELECT rolls.Dice, MAX(rolls.DiceAmount) as maxda, RoundSummary.IdCharacter as maxch
FROM rolls
LEFT JOIN RoundSummary ON (RoundSummary.IdRoll=rolls.IdRoll)
GROUP BY rolls.Dice) as mmax)
GROUP BY mmin.Dice;

-- 2


-- 3
SELECT characters.IdCharacter, characters.Name, 
		SUM(RoundSummary.DealtDamage), 
        SUM(RoundSummary.TakenDamage), 
        AVG(RoundSummary.DealtDamage), 
        AVG(RoundSummary.TakenDamage)
FROM characters
JOIN RoundSummary ON (RoundSummary.IdCharacter=characters.IdCharacter)
GROUP BY characters.IdCharacter;

-- 4
SELECT RoundSummary.IdRound, RoundSummary.CharacterHealth, RoundSummary.TakenDamage, RoundSummary.DealtDamage 
FROM RoundSummary
WHERE RoundSummary.IdCharacter = 2
ORDER BY RoundSummary.IdRound ASC;




--------------------------------------------------