use rpg_game;


DROP TABLE IF EXISTS Character_Specialization;
DROP TABLE IF EXISTS Race_Trump;
DROP TABLE IF EXISTS Race_Class;
DROP TABLE IF EXISTS Treasure_Equipment;
DROP TABLE IF EXISTS Equipment_Zone;
DROP TABLE IF EXISTS Character_Zone_Equipment;
DROP TABLE IF EXISTS Character_Equipment;
DROP TABLE IF EXISTS Character_Buff;
DROP TABLE IF EXISTS Equipment_Modifier;
DROP TABLE IF EXISTS Trump_Equipment;
DROP TABLE IF EXISTS Buff_Modifier;
DROP TABLE IF EXISTS Specialization_Trump;
DROP TABLE IF EXISTS Specialization_Skill;
DROP TABLE IF EXISTS Roll_Skill;
DROP TABLE IF EXISTS Action_Skill;
DROP TABLE IF EXISTS Character_Skill;
DROP TABLE IF EXISTS Character_Action;
DROP TABLE IF EXISTS Treasure_Field;
DROP TABLE IF EXISTS Treasure_Quest;
DROP TABLE IF EXISTS Character_Quest;
DROP TABLE IF EXISTS Quest_Action;
DROP TABLE IF EXISTS RoundSummary;
DROP TABLE IF EXISTS zones;
DROP TABLE IF EXISTS equipments;
DROP TABLE IF EXISTS treasures;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS rolls;
DROP TABLE IF EXISTS rounds;
DROP TABLE IF EXISTS trumps;
DROP TABLE IF EXISTS quests;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS specializations;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS races;
DROP TABLE IF EXISTS buffs;
DROP TABLE IF EXISTS modifiers; 
DROP TABLE IF EXISTS actions;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS fields;



-- DROP TABLE IF EXISTS Treasure_Equipment;
-- DROP TABLE IF EXISTS Outfit_Equipment;
-- DROP TABLE IF EXISTS Equipment_Zone;
-- DROP TABLE IF EXISTS Trump_Equipment;
-- DROP TABLE IF EXISTS Equipment_Modifier;
-- DROP TABLE IF EXISTS Character_Buff;
-- DROP TABLE IF EXISTS Buff_Modifier;
-- DROP TABLE IF EXISTS Race_Trump;
-- DROP TABLE IF EXISTS Character_Specialization;
-- DROP TABLE IF EXISTS Specialization_Trump;
-- DROP TABLE IF EXISTS Specialization_Skill;
-- DROP TABLE IF EXISTS Roll_Skill;
-- DROP TABLE IF EXISTS Treasure_Quest;
-- DROP TABLE IF EXISTS Treasure_Field;
-- DROP TABLE IF EXISTS Quest_Action;
-- DROP TABLE IF EXISTS Character_Zone;
-- DROP TABLE IF EXISTS Character_Equipment;
-- DROP TABLE IF EXISTS Character_Action;
-- DROP TABLE IF EXISTS Character_Quest;
-- DROP TABLE IF EXISTS Round_Action;
-- DROP TABLE IF EXISTS Action_Skill;
-- DROP TABLE IF EXISTS Race_Class;
-- DROP TABLE IF EXISTS Action_Target;
-- DROP TABLE IF EXISTS Action_Target_Round;

-- DROP TABLE IF EXISTS zones;
-- DROP TABLE IF EXISTS treasures;
-- DROP TABLE IF EXISTS equipments;
-- DROP TABLE IF EXISTS rounds;
-- DROP TABLE IF EXISTS actions;
-- DROP TABLE IF EXISTS rolls;
-- DROP TABLE IF EXISTS skills;
-- DROP TABLE IF EXISTS specializations;
-- DROP TABLE IF EXISTS trumps;
-- DROP TABLE IF EXISTS buffs;
-- DROP TABLE IF EXISTS modifiers;
-- DROP TABLE IF EXISTS quests;
-- DROP TABLE IF EXISTS board;
-- DROP TABLE IF EXISTS characters;
-- DROP TABLE IF EXISTS fields;
-- DROP TABLE IF EXISTS races;
-- DROP TABLE IF EXISTS classes;
-- DROP TABLE IF EXISTS teams;


-- Zones 
-- Equipments
-- Treasures
-- Teams
-- Fields
-- Rounds
-- Trumps
-- Classes
-- Races
-- Buffs
-- Modifier
-- Actions
-- Skills
-- Board
-- Characters
-- Rolls
-- Specializations
-- Quests
-- Character_Specialization
-- Race_Trump
-- Race_Class
-- Treasure_Equipment
-- Equipment_Zone
-- Character_Zone_Equipment
-- Character_Equipment
-- Character_Buff
-- Equipment_Modifier
-- Trump_Equipment
-- Buff_Modifier
-- Specialization_Trump
-- Specialization_Skill
-- Roll_Skill
-- Action_Skill
-- Character_Skill
-- Character_Action
-- Treasure_Field
-- Treasure_Quest
-- Character_Quest
-- Quest_Action
-- RoundSummaru



 CREATE TABLE IF NOT EXISTS zones(
 	IdZone INT NOT NULL AUTO_INCREMENT UNIQUE,
    ZoneName VARCHAR(30) NOT NULL UNIQUE,
    CHECK(ZoneName<>''),
    PRIMARY KEY(IdZone)
 );

 CREATE TABLE IF NOT EXISTS equipments(
    IdEquipm INT NOT NULL AUTO_INCREMENT UNIQUE,
    EquipmName VARCHAR(30) NOT NULL UNIQUE,
    EquipmValue INT NOT NULL DEFAULT 0,
    EquipmDescription VARCHAR(50) NOT NULL,
    CHECK(EquipmName<>'' AND EquipmValue>=0 AND EquipmDescription<>''),
    PRIMARY KEY(IdEquipm)
 );

 CREATE TABLE IF NOT EXISTS treasures(
    IdTreasure INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdTreasure)
 );

 CREATE TABLE IF NOT EXISTS teams(
 	IdTeam INT NOT NULL AUTO_INCREMENT UNIQUE,
    TeamName VARCHAR(50) NOT NULL UNIQUE,
    CHECK(TeamName<>''),
    PRIMARY KEY(IdTeam)
 );

 CREATE TABLE IF NOT EXISTS fields(
 	IdField INT NOT NULL AUTO_INCREMENT UNIQUE,
 	XCoordinate INT NOT NULL,
 	YCoordinate INT NOT NULL,
 	CHECK(XCoordinate >= 0 AND YCoordinate >= 0),
    PRIMARY KEY(IdField)
 );

 CREATE TABLE IF NOT EXISTS rounds(
    IdRound INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdRound)
 );

 CREATE TABLE IF NOT EXISTS trumps(
    IdTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    TrumpName VARCHAR(30) NOT NULL UNIQUE,
    TrumpDescription VARCHAR(50) NOT NULL,
    CHECK(TrumpName<>'' AND TrumpDescription<>''),
    PRIMARY KEY(IdTrump)
 );

 CREATE TABLE IF NOT EXISTS classes(
    IdClass INT NOT NULL AUTO_INCREMENT UNIQUE,
    ClassName VARCHAR(30) NOT NULL UNIQUE,
    ClassDescription VARCHAR(50) NOT NULL,
    CHECK(ClassName<>'' AND ClassDescription<>''),
    PRIMARY KEY(IdClass)
 );

 CREATE TABLE IF NOT EXISTS races(
    IdRace INT NOT NULL AUTO_INCREMENT UNIQUE,
    RaceName VARCHAR(30) NOT NULL UNIQUE,
    RaceDescription VARCHAR(50) NOT NULL,
    CHECK(RaceName<>'' AND RaceDescription<>''),
    PRIMARY KEY(IdRace)
 );

 CREATE TABLE IF NOT EXISTS buffs(
    IdBuff INT NOT NULL AUTO_INCREMENT UNIQUE,
    BuffName VARCHAR(30) NOT NULL UNIQUE,
    BuffDescription VARCHAR(50) NOT NULL,
    DurationTime INT NOT NULL DEFAULT 1,
    CHECK(BuffName<>'' AND BuffDescription<>'' AND DurationTime>0),
    PRIMARY KEY(IdBuff)
 );

 CREATE TABLE IF NOT EXISTS modifiers(
    IdMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    ModName VARCHAR(30) NOT NULL UNIQUE,
    CHECK(ModName<>''),
    PRIMARY KEY(IdMod)
 ); 

 CREATE TABLE IF NOT EXISTS actions(
    IdAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    ActionName VARCHAR(30) NOT NULL UNIQUE,
    ActionDescription VARCHAR(50) NOT NULL,
    CHECK(ActionName<>'' AND ActionDescription<>''),
    PRIMARY KEY(IdAction)
 );

 CREATE TABLE IF NOT EXISTS skills(
    IdSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
    SkillName VARCHAR(30) NOT NULL UNIQUE,
    SkillDescription VARCHAR(50) NOT NULL,
    CHECK(SkillName<>'' AND SkillDescription<>''),
    PRIMARY KEY(IdSkill)
 );

CREATE TABLE IF NOT EXISTS board(
    IdNeighbourhood INT NOT NULL AUTO_INCREMENT UNIQUE,
    Field_1 INT DEFAULT NULL,
    Field_2 INT DEFAULT NULL,
    FOREIGN KEY(Field_1) REFERENCES fields(IdField)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(Field_2) REFERENCES fields(IdField)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CHECK(IS_NOT(Field_1 = Field_2)),
    PRIMARY KEY(IdNeighbourhood)
);

 CREATE TABLE IF NOT EXISTS characters(
    IdCharacter INT NOT NULL AUTO_INCREMENT UNIQUE,
    Name VARCHAR(30) NOT NULL DEFAULT '',
    Level INT NOT NULL DEFAULT 0,
    Strength INT NOT NULL DEFAULT 0,
    Ability INT NOT NULL DEFAULT 0,
    Construction INT NOT NULL DEFAULT 0,
    Intellect INT NOT NULL DEFAULT 0,
    Prudence INT NOT NULL DEFAULT 0,
    Charisma INT NOT NULL DEFAULT 0,
    BaseHP INT NOT NULL DEFAULT 0,
    CurrentHP INT NOT NULL DEFAULT 0,
    BaseDamage INT NOT NULL DEFAULT 0,

    IdField INT,
    IdRace INT NOT NULL,
    IdTeam INT DEFAULT NULL,

    CHECK (Level>=0 AND Strength>=0 AND Ability>=0 AND
            Construction>=0 AND Intellect>=0 AND 
            Prudence>=0 AND Charisma>=0 AND
            Name<>''),
    FOREIGN KEY (IdField) REFERENCES fields(IdField)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdRace) REFERENCES races(IdRace)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdTeam) REFERENCES teams(IdTeam)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacter)
 );

 CREATE TABLE IF NOT EXISTS rolls(
    IdRoll INT NOT NULL AUTO_INCREMENT UNIQUE,
    Dice INT NOT NULL DEFAULT 1,
    DiceAmount INT NOT NULL DEFAULT 1,
    IdRound INT NOT NULL,
    FOREIGN KEY (IdRound) REFERENCES rounds(IdRound)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CHECK(Dice>=0 AND DiceAmount>=0),
    PRIMARY KEY(IdRoll)
 );
 
 CREATE TABLE IF NOT EXISTS specializations(
    IdSpec INT NOT NULL AUTO_INCREMENT UNIQUE,
    SpecName VARCHAR(30) NOT NULL UNIQUE,
    SpecDescription VARCHAR(80) NOT NULL,

    IdClass INT,
    FOREIGN KEY (IdClass) REFERENCES classes(IdClass)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CHECK(SpecName<>'' AND SpecDescription<>''),
    PRIMARY KEY(IdSpec)
 );

 CREATE TABLE IF NOT EXISTS quests(
    IdQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
    QuestDescription VARCHAR(50) NOT NULL,
    IdCharacter INT,
    CHECK(QuestDescription<>''),
    FOREIGN KEY(IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdQuest)
 );

CREATE TABLE IF NOT EXISTS Character_Specialization(
    IdCharSpec INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL, 
    IdSpec INT NOT NULL,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharSpec)
);

CREATE TABLE IF NOT EXISTS Race_Trump(
    IdRaceTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdTrump INT NOT NULL,
    IdRace INT NOT NULL,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdRace) REFERENCES races(IdRace)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdRaceTrump)
);

CREATE TABLE IF NOT EXISTS Race_Class(
    IdRaceClass INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdRace INT NOT NULL,
    IdClass INT NOT NULL,
    FOREIGN KEY (IdRace) REFERENCES races(IdRace)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdClass) REFERENCES classes(IdClass)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdRaceClass)
);


CREATE TABLE IF NOT EXISTS Treasure_Equipment(
    IdTreasureEquipm INT NOT NULL AUTO_INCREMENT,
    Amount INT NOT NULL DEFAULT 1,
    IdTreasure INT NOT NULL,
    IdEquipm INT NOT NULL,
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdTreasureEquipm)
);

CREATE TABLE IF NOT EXISTS Equipment_Zone(
    IdEquipmentZone INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdEquipm INT NOT NULL,
    IdZone INT NOT NULL,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (IdEquipmentZone)
);

CREATE TABLE IF NOT EXISTS Character_Zone_Equipment(
    IdCharacterZone INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    IdZone INT NOT NULL,
    IdEquipm INT NOT NULL,
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacterZone)
);

CREATE TABLE IF NOT EXISTS Character_Equipment(
    IdCharacterEquipm INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    IdEquipm INT NOT NULL,
    Amount INT NOT NULL,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacterEquipm)
);

CREATE TABLE IF NOT EXISTS Character_Buff(
    IdCharacterBuff INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    IdBuff INT NOT NULL,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdBuff) REFERENCES buffs(IdBuff)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacterBuff)
);

CREATE TABLE IF NOT EXISTS Equipment_Modifier(
    IdEquipmMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdMod INT NOT NULL,
    IdEquipm INT NOT NULL,
    ModifierValue INT NOT NULL DEFAULT 0,
    FOREIGN KEY (IdMod) REFERENCES modifiers(IdMod)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdEquipmMod)
);

CREATE TABLE IF NOT EXISTS Trump_Equipment(
	IdTrumpEquipment INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdTrump INT NOT NULL,
    IdEquipm INT NOT NULL,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdTrumpEquipment)
);

CREATE TABLE IF NOT EXISTS Buff_Modifier(
	IdBuffMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    ModifierValue INT NOT NULL DEFAULT 0,
    IdMod INT NOT NULL,
    IdBuff INT NOT NULL,
    CHECK(ModifierValue>=0),
    FOREIGN KEY (IdMod) REFERENCES modifiers(IdMod)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdBuff) REFERENCES buffs(IdBuff)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdBuffMod)
);

CREATE TABLE IF NOT EXISTS Specialization_Trump(
	IdSpecTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdTrump INT NOT NULL,
    IdSpec INT NOT NULL,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdSpecTrump)
);

CREATE TABLE IF NOT EXISTS Specialization_Skill(
    IdSpecializationSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdSpec INT NOT NULL,
    IdSkill INT NOT NULL,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdSpecializationSkill)
);

CREATE TABLE IF NOT EXISTS Roll_Skill(
    IdRollSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdRoll INT NOT NULL,
    IdSkill INT NOT NULL,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdRoll) REFERENCES rolls(IdRoll)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdRollSkill)
);

CREATE TABLE IF NOT EXISTS Action_Skill(
    IdActionSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdAction INT NOT NULL,
    IdSkill INT NOT NULL,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdActionSkill)
);

-- TODO
CREATE TABLE IF NOT EXISTS Character_Skill(
    IdCharacterSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    IdSkill INT NOT NULL,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacterSkill)
);


CREATE TABLE IF NOT EXISTS Character_Action(
    IdCharacterAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    IdAction INT NOT NULL,
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacterAction)
);

CREATE TABLE IF NOT EXISTS Treasure_Field(
    IdTreasureField INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdField INT NOT NULL,
    IdTreasure INT NOT NULL,
    FOREIGN KEY (IdField) REFERENCES fields(IdField)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdTreasureField)
);

CREATE TABLE IF NOT EXISTS Treasure_Quest(
    IdTreasureQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdQuest INT NOT NULL,
    IdTreasure INT NOT NULL,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdTreasureQuest)
);

CREATE TABLE IF NOT EXISTS Character_Quest(
    IdCharacterQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdQuest INT NOT NULL,
    IdCharacter INT NOT NULL,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdCharacterQuest)
);

CREATE TABLE IF NOT EXISTS Quest_Action(
    IdQuestAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdQuest INT NOT NULL,
    IdAction INT NOT NULL,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdQuestAction)
);

CREATE TABLE IF NOT EXISTS RoundSummary(
    IdRoundSummary INT NOT NULL AUTO_INCREMENT UNIQUE,
    CharacterHealth INT NOT NULL,
    DealtDamage INT NOT NULL DEFAULT 0,
    TakenDamage INT NOT NULL DEFAULT 0,
    IdRound INT NOT NULL,
    IdRoll INT NOT NULL,
    IdCharacter INT NOT NULL,
    IdAction INT NOT NULL,
    IdTarget INT NOT NULL,
    FOREIGN KEY (IdRound) REFERENCES rounds(IdRound)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdRoll) REFERENCES rolls(IdRoll)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (IdTarget) REFERENCES fields(IdField)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY(IdRoundSummary)
);





    












-- CREATE TABLE IF NOT EXISTS Round_Action(
-- 	IdRoundAction INT NOT NULL AUTO_INCREMENT UNIQUE,
--     IdRound INT NOT NULL,
--     IdAction INT NOT NULL,
--     FOREIGN KEY (IdRound) REFERENCES rounds(IdRound)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (IdAction) REFERENCES actions(IdAction)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     PRIMARY KEY(IdRoundAction)
-- );


-- CREATE TABLE IF NOT EXISTS Action_Target(
--     IdActionTarget INT NOT NULL UNIQUE DEFAULT 1,
--     IdCharacterAction INT NOT NULL,
--     IdField INT NOT NULL,
--     FOREIGN KEY( IdCharacterAction) REFERENCES Character_Action(IdCharacterAction)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY(IdField) REFERENCES fields(IdField)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     PRIMARY KEY(IdActionTarget)
--  );

--  CREATE TABLE IF NOT EXISTS Action_Target_Round(
--     IdActionTargetRound INT NOT NULL UNIQUE DEFAULT 1,
--     IdActionTarget INT NOT NULL,
--     IdRound INT NOT NULL,
--     FOREIGN KEY(IdActionTarget) REFERENCES Action_Target(IdActionTarget)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY(IdRound) REFERENCES rounds(IdRound)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     PRIMARY KEY(IdActionTargetRound)
--  );