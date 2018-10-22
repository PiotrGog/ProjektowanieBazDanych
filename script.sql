use project_db;

DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS zones;
DROP TABLE IF EXISTS treasures;
DROP TABLE IF EXISTS outfits;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS equipments;
DROP TABLE IF EXISTS fields;
DROP TABLE IF EXISTS quests;
DROP TABLE IF EXISTS rounds;
DROP TABLE IF EXISTS actions;
DROP TABLE IF EXISTS rolls;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS specializations;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS trumps;
DROP TABLE IF EXISTS races;
DROP TABLE IF EXISTS buffs;
DROP TABLE IF EXISTS modifiers;


 CREATE TABLE IF NOT EXISTS characters(
	IdCharacter INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    Name VARCHAR(30) NOT NULL UNIQUE,
    Level INT NOT NULL DEFAULT 0,
    Strength INT NOT NULL DEFAULT 0,
    Ability INT NOT NULL DEFAULT 0,
    Construction INT NOT NULL DEFAULT 0,
    Intellect INT NOT NULL DEFAULT 0,
    Prudence INT NOT NULL DEFAULT 0,
    Charisma INT NOT NULL DEFAULT 0,

	CHECK (Level>=0 AND Strength>=0 AND Ability>=0 AND
			Construction>=0 AND Intellect>=0 AND Prudence>=0 AND Charisma>=0),
    PRIMARY KEY(IdCharacter)
 );

 CREATE TABLE IF NOT EXISTS zones(
 	IdZone INT NOT NULL UNIQUE DEFAULT 1,
    ZoneName VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY(IdZone)
 );


 CREATE TABLE IF NOT EXISTS treasures(
 	IdTreasure INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    PRIMARY KEY(IdTreasure)
 );


 CREATE TABLE IF NOT EXISTS outfits(
 	IdOutfit INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    PRIMARY KEY(IdOutfit)
 );

 CREATE TABLE IF NOT EXISTS teams(
 	IdTeam INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    TeamName VARCHAR(30) UNIQUE,
    PRIMARY KEY(IdTeam)
 );

 CREATE TABLE IF NOT EXISTS equipments(
	IdEquipm INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    EquipmName VARCHAR(30) UNIQUE,
    EquipmValue INT NOT NULL DEFAULT 0,
    EquipmDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdEquipm)
 );


 CREATE TABLE IF NOT EXISTS fields(
 	IdField INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 0,
    PRIMARY KEY(IdField)
 );


 CREATE TABLE IF NOT EXISTS quests(
	IdQuest INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
 	QuestDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdQuest)
 );


 CREATE TABLE IF NOT EXISTS rounds(
 	IdRound INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    PRIMARY KEY(IdRound)
 );


 CREATE TABLE IF NOT EXISTS actions(
 	IdAction INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    ActionName VARCHAR(30) NOT NULL UNIQUE,
    ActionDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdAction)
 );


 CREATE TABLE IF NOT EXISTS rolls(
 	IdRoll INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    Dice INT NOT NULL DEFAULT 1,
    DiceAmount INT NOT NULL DEFAULT 1,
    PRIMARY KEY(IdRoll)
 );


 CREATE TABLE IF NOT EXISTS skills(
	IdSkill INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1
    SkillName VARCHAR(30) NOT NULL UNIQUE,
    SkillDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdSkill)
 );


 CREATE TABLE IF NOT EXISTS specializations(
	IdSpec INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    SpecName VARCHAR(30) NOT NULL UNIQUE,
    SpecDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdSpec)
 );


 CREATE TABLE IF NOT EXISTS classes(
 	IdClass INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    ClassName VARCHAR(30) NOT NULL UNIQUE,
    ClassDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdClass)
 );


 CREATE TABLE IF NOT EXISTS trumps(
 	IdTrump INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    TrumpName VARCHAR(30) NOT NULL UNIQUE,
    TrumpDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdTrump)
 );

 CREATE TABLE IF NOT EXISTS races(
	IdRace INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
 	RaceName VARCHAR(30) NOT NULL UNIQUE,
    RaceDescription VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdRace)
 );


 CREATE TABLE IF NOT EXISTS buffs(
 	IdBuff INT NOT NULL AUTO_INCREMENT UNIQUE DEFAULT 1,
    BuffName VARCHAR(30) NOT NULL UNIQUE,
    BuffDescription VARCHAR(50) NOT NULL,
    DurationTime INT NOT NULL DEFAULT 1,
    CHECK(DurationTime>0),
    PRIMARY KEY(IdBuff)
 );

 CREATE TABLE IF NOT EXISTS modifiers(
 	IdMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    ModName VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY(IdMod)
 ); 

CREATE TABLE IF NOT EXISTS Treasure_Equipment(
	IdTreasureEquipm INT NOT NULL AUTO_INCREMENT DEFAULT 1,
    Amount INT NOT NULL DEFAULT 1,
    IdTreasure INT,
    IdEquipm INT,
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdTreasureEquipm)
);

CREATE TABLE IF NOT EXISTS Outfit_Equipment(
    IdOutfitEquipm INT NOT NULL AUTO_INCREMENT DEFAULT 1,
	IdOutfit INT,
    IdEquipm INT,
    FOREIGN KEY (IdOutfit) REFERENCES outfits(IdOutfit),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm)
    -- PRIMARY KEY(IdTreasureEquipm)
);

CREATE TABLE IF NOT EXISTS Outfit_Zone(
	IdOutfit INT,
    IdZone INT,
    FOREIGN KEY (IdOutfit) REFERENCES outfits(IdOutfit),
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Equipment_Zone(
	IdEquipm INT,
    IdZone INT,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Outfit(
	IdCharacter INT,
    IdOutfit INT,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdOutfit) REFERENCES outfits(IdOutfit)
    -- PRIMARY KEY(IdTreasureEquipm) 
);

CREATE TABLE IF NOT EXISTS Character_Outfit(
	IdCharacterZone INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdCharacter INT,
    IdZone INT,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone),
    PRIMARY KEY(IdCharacterZone)
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
