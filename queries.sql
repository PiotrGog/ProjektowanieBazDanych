1_1

SELECT * FROM characters WHERE IdCharachter == given_id;

1_2


SELECT Strength, Ability, Construction, Intellect, Proudence, Charisma FROM characters WHERE IdCharachter == given_id;

SELECT buff_modifers.ModiferValue, modifers.ModName, zones.ZoneName, equipments.EquipmName FROM equipments 
	JOIN equipment_zone ON equipment_zone.IdEquipm == equipments.IdEquipm
		JOIN zones ON zones.IdZone == equipment_zone.IdZone
		    JOIN character_zone ON charackter_zone.IdZone == zones.IdZone	
				WHERE character_zone.IdCharachter == given_id;	




-- FROM modifers 
-- 	JOIN buff_modifer ON modifers.IdMod == buff_modifer.IdMod
-- 		JOIN character_buff ON character_buff.IdBuff == buff_modifer.IdBuff
-- 			JOIN characters ON character_buff.IdCharacter == characters.IdCharacter
-- 				WHERE IdCharachter == given_id;

SELECT zones.ZoneName, equipments.EquipmName FROM equipments 
	JOIN equipment_zone ON equipment_zone.IdEquipm == equipments.IdEquipm
		JOIN zones ON zones.IdZone == equipment_zone.IdZone
		    JOIN character_zone ON charackter_zone.IdZone == zones.IdZone	
				WHERE character_zone.IdCharachter == given_id;	

1_3

SELECT zones.ZoneName, equipments.EquipmName FROM equipments 
	JOIN equipment_zone ON equipment_zone.IdEquipm == equipments.IdEquipm
		JOIN zones ON zones.IdZone == equipment_zone.IdZone
		    JOIN character_zone ON charackter_zone.IdZone == zones.IdZone	
				WHERE character_zone.IdCharachter == given_id;	

1_4

SELECT * FROM modifers 
	JOIN modifer_equipment ON modifers.IdMod == modifer_equipment.IdMod
		JOIN equipments ON modifer_equipment.IdEquipm == equipments.IdEquipm 
			WHERE equipments.EquipmName == given_name;

1_5	

SELECT fields.XCoordinate, fields.YCoordinate, charchters.Name  FROM board 
	LEFT JOIN characters fields.IdField == charchters.IdField;

SELECT skills.Name, skills.description, rolls.Dice, rolls.Dice_amount FROM characters
	WHERE character.IdCharacter == given_id
		JOIN character_specialization ON character_specialization.ICharacter == characters.IdCharacter
			JOIN specialization_skill ON character_specialization.IdSpec == specialization_skill.IdSpec
				JOIN skills ON skills.IdSkill == JOIN skills ON skills.IdSkill == action_skill.IdSkill.IdSkill
					JOIN roll_skill ON skills.IdSkill == roll_skill.IdSkill
						JOIN rolls ON rolls.IdRoll == roll_skill.IdRoll;


SELECT actions.Name, actions.description, rolls.Dice, rolls.Dice_amount FROM characters
	WHERE character.IdCharacter == given_id
		JOIN character_action ON character_action.ICharacter == characters.IdCharacter
			JOIN action ON character_action.IdAction == actions.IdAction
				JOIN action_skill ON character_action.IdAction == action_skill.IdAction
					JOIN skills ON skills.IdSkill == JOIN skills ON skills.IdSkill == action_skill.IdSkill.IdSkill
						JOIN roll_skill ON skills.IdSkill == roll_skill.IdSkill
							JOIN rolls ON rolls.IdRoll == roll_skill.IdRoll;			
2

INSERT INTO characters (Name, Level, Stregth, Intellect, Prodence, Charisma, IdField, IdRace, IdTeam)
	VALUES ("Valeria Windrunner", 76, 12, 8, 16, 17, 2, 4, 1);
3_1

SELECT character.IdCaracter, characters.Level, characters.Name FROM charachters;

SELECT COUNT(IdCharacter) FROM characters ;

SELECT COUNT(IdCharacter) FROM characters WHERE
	charchters.Strength >= our_character_strength;

SELECT COUNT(IdCharacter) FROM characters WHERE
	charchters.Dexterity >= our_character_dexterity;

SELECT COUNT(IdCharacter) FROM characters WHERE
	charchters.Constitution>= our_character_constitution;

SELECT COUNT(IdCharacter) FROM characters WHERE
	charchters.Intelligence >= our_character_inteligence;

SELECT COUNT(IdCharacter) FROM characters WHERE
	charchters.Wisdom >= our_character_wisdom;

SELECT COUNT(IdCharacter) FROM characters WHERE
	charchters.Charisma >= our_character_charisma;

	
3_2

SELECT * FROM characters WHERE IdCharachter == given_id;


4

SELECT round_action.IdRound, actions,ActionName, rolls.Dice, rolls.DiceAmount, skills.SkillName, characters.Name, charachters.BaseAttack FROM rounds 
	JOIN action ON round_action.IdAction == actions.IdAction
		JOIN character_action ON character_action.IdAction == actions.IdAction
			JOIN characters ON characters.IdCharacter == character_action.IdCharacter
				JOIN action_skill ON action_skill.IdSkill== actions.IdAction
					JOIN skills ON skills.IdSkill == action_skill.IdSkill
						JOIN roll_skill ON skills.IdSkill == roll_skill.IdSkill
							JOIN rolls ON rolls.IdRoll == roll_skill.IdRoll;