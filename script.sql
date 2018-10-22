use project_db;

DROP TABLE characters;
DROP TABLE zones;
DROP TABLE treasures;
DROP TABLE teams;
DROP TABLE equipments;
DROP TABLE fields;
DROP TABLE quests;
DROP TABLE rounds;
DROP TABLE actions;
DROP TABLE rolls;
DROP TABLE skills;
DROP TABLE specializations;
DROP TABLE classes;
DROP TABLE trumps;
DROP TABLE races;
DROP TABLE buffs;
DROP TABLE modifiers;


 CREATE TABLE IF NOT EXISTS characters(
	IdCharacter INT NOT NULL AUTO_INCREMENT UNIQUE,
    Name VARCHAR(30) NOT NULL UNIQUE,
    Level INT NOT NULL,
    Strength INT NOT NULL,
    Ability INT NOT NULL,
    Construction INT NOT NULL,
    Intellect INT NOT NULL,
    Prudence INT NOT NULL,
    Charisma INT NOT NULL,
    
    PRIMARY KEY(IdCharacter)
 );

 CREATE TABLE IF NOT EXISTS zones(
 	IdZone INT NOT NULL UNIQUE,
    ZoneName VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY(IdZone)
 );


 CREATE TABLE IF NOT EXISTS treasures(
 	IdTreasure INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdTreasure)
 );

 CREATE TABLE IF NOT EXISTS teams(
 	IdTeam INT NOT NULL AUTO_INCREMENT UNIQUE,
    TeamName VARCHAR(30) UNIQUE,
    PRIMARY KEY(IdTeam)
 );

 CREATE TABLE IF NOT EXISTS equipments(
	IdEquipm INT NOT NULL AUTO_INCREMENT UNIQUE,
    EquipmName VARCHAR(30) UNIQUE,
    EquipmValue INT NOT NULL,
    EquimpValue VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdEquipm)
 );


 CREATE TABLE IF NOT EXISTS fields(
 	IdField INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdField)
 );


 CREATE TABLE IF NOT EXISTS quests(
	IdQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
 	QuestDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdQuest)
 );


 CREATE TABLE IF NOT EXISTS rounds(
 	IdRound INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdRound)
 );


 CREATE TABLE IF NOT EXISTS actions(
 	IdAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    ActionName VARCHAR(30) NOT NULL UNIQUE,
    ActionDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdAction)
 );


 CREATE TABLE IF NOT EXISTS rolls(
 	IdRoll INT NOT NULL AUTO_INCREMENT UNIQUE,
    Dice INT NOT NULL,
    DiceAmount INT NOT NULL,
    PRIMARY KEY(IdRoll)
 );


 CREATE TABLE IF NOT EXISTS skills(
	IdSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
    SkillName VARCHAR(30) NOT NULL UNIQUE,
    SkillDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdSkill)
 );


 CREATE TABLE IF NOT EXISTS specializations(
	IdSpec INT NOT NULL AUTO_INCREMENT UNIQUE,
    SpecName VARCHAR(30) NOT NULL UNIQUE,
    SpecDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdSpec)
 );


 CREATE TABLE IF NOT EXISTS classes(
 	IdClass INT NOT NULL AUTO_INCREMENT UNIQUE,
    ClassName VARCHAR(30) NOT NULL UNIQUE,
    ClassDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdClass)
 );


 CREATE TABLE IF NOT EXISTS trumps(
 	IdTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    TrumpName VARCHAR(30) NOT NULL UNIQUE,
    TrumpDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdTrump)
 );

 CREATE TABLE IF NOT EXISTS races(
	IdRace INT NOT NULL AUTO_INCREMENT UNIQUE,
 	RaceName VARCHAR(30) NOT NULL UNIQUE,
    RaceDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdRace)
 );


 CREATE TABLE IF NOT EXISTS buffs(
 	IdBuff INT NOT NULL AUTO_INCREMENT UNIQUE,
    BuffName VARCHAR(30) NOT NULL UNIQUE,
    BuffDescription VARCHAR(50) NOT NULL,
    DurationTime INT NOT NULL,
    PRIMARY KEY(IdBuff)
 );

 CREATE TABLE IF NOT EXISTS modifiers(
 	IdMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    ModName VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY(IdMod)
 ); 

CREATE TABLE IF NOT EXISTS Treasure_Equipment(
	IdTreasureEquipm INT NOT NULL AUTO_INCREMENT,
    Amount INT NOT NULL,
    IdTreasure INT,
    IdEquipm INT,
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdTreasureEquipm)
);

CREATE TABLE IF NOT EXISTS Equipment_Zone(
	IdEquipm INT,
    IdZone INT,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone)
    -- PRIMARY KEY(IdTreasureEquipm) 
);
    
CREATE TABLE IF NOT EXISTS Trump_Equipment(
	IdTrumpEquipment INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdTrump INT,
    IdEquipm INT,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdTrumpEquipment)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Equipment_Modifier(
	IdEquipmMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdMod INT,
    IdEquipm INT,
    FOREIGN KEY (IdMod) REFERENCES modifiers(IdMod),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdEquipmMod)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Buff(
	IdCharacter INT,
    IdBuff INT,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacater),
    FOREIGN KEY (IdBuff) REFERENCES buffs(IdBuff),
    PRIMARY KEY(IdCharacter)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Buff_Modifier(
	IdBuffMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdMod INT,
    IdBuff INT,
    ModifierValue INT NOT NULL,
    FOREIGN KEY (IdMod) REFERENCES modifiers(IdMod),
    FOREIGN KEY (IdBuff) REFERENCES buffs(IdBuff),
    PRIMARY KEY(IdBuffMod)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Race_Trump(
	IdRaceTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdTrump INT,
    IdRace INT,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump),
    FOREIGN KEY (IdRace) REFERENCES races(IdRace),
    PRIMARY KEY(IdRaceTrump)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Race_Class(
	IdRace INT,
    IdClass INT,
    FOREIGN KEY (IdRace) REFERENCES races(IdRace),
    FOREIGN KEY (IdClass) REFERENCES classes(IdClass),
    PRIMARY KEY(IdRace)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Specialization(
	IdCharSpec INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT,
    IdSpec INT,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec),
    PRIMARY KEY(IdCharSpec)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Specialization_Trump(
	IdSpecTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdTrump INT,
    IdSpec INT,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump),
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec),
    PRIMARY KEY(IdSpecTrump)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Specialization_Skill(
	IdSpec INT,
    IdSkill INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec),
    PRIMARY KEY(IdSpec)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Roll_Skill(
	IdRoll INT,
    IdSkill INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdRoll) REFERENCES rolls(IdRoll),
    PRIMARY KEY(IdRoll)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Action_Skill(
	IdAction INT,
    IdSkill INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    PRIMARY KEY(IdAction)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Round_Action(
	IdRoundAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdRound INT,
    IdAction INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    PRIMARY KEY(IdRoundAction)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Quest(
	IdQuest INT,
    IdCharacter INT,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest),
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    PRIMARY KEY(IdQuest)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Action(
	IdCharacterAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT,
    IdAction INT,
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    PRIMARY KEY(IdCharacterAction)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Treasure_Quest(
	IdQuest INT,
    IdTreasure INT,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest),
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    PRIMARY KEY(IdQuest)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Zone(
	IdCharacterZone INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT,
    IdZone INT,
    IdEquipm INT,
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone),
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdCharacterZone)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Equipment(
	IdCharacter INT,
    IdEquipm INT,
    Amount INT NOT NULL,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdEquipm)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Treasure_Field(
	IdField INT,
    IdTreasure INT,
    FOREIGN KEY (IdField) REFERENCES fields(IdField),
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    PRIMARY KEY(IdField)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Quest_Action(
	IdQuestAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdQuest INT,
    IdAction INT,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest),
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    PRIMARY KEY(IdQuestAction)
    -- PRIMARY KEY(IdTreasureEquipm) 
);
