use project_db;


DROP TABLE IF EXISTS Treasure_Equipment;
DROP TABLE IF EXISTS Outfit_Equipment;
DROP TABLE IF EXISTS Outfit_Zone;
DROP TABLE IF EXISTS Equipment_Zone;
DROP TABLE IF EXISTS Trump_Equipment;
DROP TABLE IF EXISTS Equipment_Modifier;
DROP TABLE IF EXISTS Character_Buff;
DROP TABLE IF EXISTS Buff_Modifier;
DROP TABLE IF EXISTS Race_Trump;
DROP TABLE IF EXISTS Character_Specialization;
DROP TABLE IF EXISTS Specialization_Trump;
DROP TABLE IF EXISTS Specialization_Skill;
DROP TABLE IF EXISTS Roll_Skill;
DROP TABLE IF EXISTS Treasure_Quest;
DROP TABLE IF EXISTS Treasure_Field;
DROP TABLE IF EXISTS Quest_Action;
DROP TABLE IF EXISTS Character_Zone;
DROP TABLE IF EXISTS Character_Equipment;
DROP TABLE IF EXISTS Character_Action;
DROP TABLE IF EXISTS Character_Quest;
DROP TABLE IF EXISTS Round_Action;
DROP TABLE IF EXISTS Action_Skill;
DROP TABLE IF EXISTS Race_Class;

DROP TABLE IF EXISTS zones;
DROP TABLE IF EXISTS treasures;
DROP TABLE IF EXISTS outfits;
DROP TABLE IF EXISTS equipments;
DROP TABLE IF EXISTS rounds;
DROP TABLE IF EXISTS actions;
DROP TABLE IF EXISTS rolls;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS specializations;
DROP TABLE IF EXISTS trumps;
DROP TABLE IF EXISTS buffs;
DROP TABLE IF EXISTS modifiers;
DROP TABLE IF EXISTS quests;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS fields;
DROP TABLE IF EXISTS races;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS teams;





 CREATE TABLE IF NOT EXISTS zones(
 	IdZone INT NOT NULL UNIQUE DEFAULT 1,
    ZoneName VARCHAR(30) NOT NULL UNIQUE,
    CHECK(ZoneName<>''),
    PRIMARY KEY(IdZone)
 );


 CREATE TABLE IF NOT EXISTS treasures(
 	IdTreasure INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdTreasure)
 );

 CREATE TABLE IF NOT EXISTS outfits(
 	IdOutfit INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdOutfit)
 );

 CREATE TABLE IF NOT EXISTS teams(
 	IdTeam INT NOT NULL AUTO_INCREMENT UNIQUE,
    TeamName VARCHAR(30) NOT NULL UNIQUE,
    CHECK(TeamName<>''),
    PRIMARY KEY(IdTeam)
 );

 CREATE TABLE IF NOT EXISTS equipments(
	IdEquipm INT NOT NULL AUTO_INCREMENT UNIQUE,
    EquipmName VARCHAR(30) NOT NULL UNIQUE,
    EquipmValue INT NOT NULL DEFAULT 0,
    EquipmDescription VARCHAR(50) NOT NULL,
    CHECK(EquipmName<>'' AND EquipmValue>=0 AND EquipmDescription<>''),
    PRIMARY KEY(IdEquipm)
 );


 CREATE TABLE IF NOT EXISTS fields(
 	IdField INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdField)
 );

CREATE TABLE IF NOT EXISTS board(
    IdNeighbourhood INT NOT NULL AUTO_INCREMENT UNIQUE,
    Field_1 INT NOT NULL,
    Field_2 INT NOT NULL,
    FOREIGN KEY(Field_1) REFERENCES fields(IdField),
    FOREIGN KEY(Field_2) REFERENCES fields(IdField),
    CHECK(Field_1 <> Field_2),
    PRIMARY KEY(IdNeighbourhood)
);

 CREATE TABLE IF NOT EXISTS rounds(
 	IdRound INT NOT NULL AUTO_INCREMENT UNIQUE,
    PRIMARY KEY(IdRound)
 );


 CREATE TABLE IF NOT EXISTS actions(
 	IdAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    ActionName VARCHAR(30) NOT NULL UNIQUE,
    ActionDescription VARCHAR(50) NOT NULL,
    CHECK(ActionName<>'' AND ActionDescription<>''),
    PRIMARY KEY(IdAction)
 );


 CREATE TABLE IF NOT EXISTS rolls(
 	IdRoll INT NOT NULL AUTO_INCREMENT UNIQUE,
    Dice INT NOT NULL DEFAULT 1,
    DiceAmount INT NOT NULL DEFAULT 1,
    CHECK(Dice>=0 AND DiceAmount>=0),
    PRIMARY KEY(IdRoll)
 );


 CREATE TABLE IF NOT EXISTS skills(
	IdSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
    SkillName VARCHAR(30) NOT NULL UNIQUE,
    SkillDescription VARCHAR(50) NOT NULL,
    CHECK(SkillName<>'' AND SkillDescription<>''),
    PRIMARY KEY(IdSkill)
 );


 CREATE TABLE IF NOT EXISTS specializations(
	IdSpec INT NOT NULL AUTO_INCREMENT UNIQUE,
    SpecName VARCHAR(30) NOT NULL UNIQUE,
    SpecDescription VARCHAR(50) NOT NULL,
    CHECK(SpecName<>'' AND SpecDescription<>''),
    PRIMARY KEY(IdSpec)
 );


 CREATE TABLE IF NOT EXISTS classes(
 	IdClass INT NOT NULL AUTO_INCREMENT UNIQUE,
    ClassName VARCHAR(30) NOT NULL UNIQUE,
    ClassDescription VARCHAR(50) NOT NULL,
    CHECK(ClassName<>'' AND ClassDescription<>''),
    PRIMARY KEY(IdClass)
 );


 CREATE TABLE IF NOT EXISTS trumps(
 	IdTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    TrumpName VARCHAR(30) NOT NULL UNIQUE,
    TrumpDescription VARCHAR(50) NOT NULL,
    CHECK(TrumpName<>'' AND TrumpDescription<>''),
    PRIMARY KEY(IdTrump)
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

 CREATE TABLE IF NOT EXISTS characters(
    IdCharacter INT NOT NULL AUTO_INCREMENT UNIQUE,
    Name VARCHAR(30) NOT NULL UNIQUE,
    Level INT NOT NULL DEFAULT 0,
    Strength INT NOT NULL DEFAULT 0,
    Ability INT NOT NULL DEFAULT 0,
    Construction INT NOT NULL DEFAULT 0,
    Intellect INT NOT NULL DEFAULT 0,
    Prudence INT NOT NULL DEFAULT 0,
    Charisma INT NOT NULL DEFAULT 0,

    IdField INT,
    IdRace INT,
    IdTeam INT,

    CHECK (Level>=0 AND Strength>=0 AND Ability>=0 AND
            Construction>=0 AND Intellect>=0 AND 
            Prudence>=0 AND Charisma>=0 AND
            Name<>''),
    FOREIGN KEY (IdField) REFERENCES fields(IdField),
    FOREIGN KEY (IdRace) REFERENCES races(IdRace),
    FOREIGN KEY (IdTeam) REFERENCES teams(IdTeam),
    PRIMARY KEY(IdCharacter)
 );


 CREATE TABLE IF NOT EXISTS quests(
    IdQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
    QuestDescription VARCHAR(50) NOT NULL,
    IdCharacter INT
    CHECK(QuestDescription<>''),
    FOREIGN KEY(IdCharacter) REFERENCES characters(IdCharacter),
    PRIMARY KEY(IdQuest)
 );

CREATE TABLE IF NOT EXISTS Treasure_Equipment(
	IdTreasureEquipm INT NOT NULL AUTO_INCREMENT,
    Amount INT NOT NULL DEFAULT 1,
    IdTreasure INT,
    IdEquipm INT,
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdTreasureEquipm)
);

CREATE TABLE IF NOT EXISTS Outfit_Equipment(
    IdOutfitEquipm INT NOT NULL AUTO_INCREMENT,
	IdOutfit INT,
    IdEquipm INT,
    FOREIGN KEY (IdOutfit) REFERENCES outfits(IdOutfit),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdOutfitEquipm)
);

CREATE TABLE IF NOT EXISTS Outfit_Zone(
    IdOutfitZone INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdOutfit INT,
    IdZone INT,
    FOREIGN KEY (IdOutfit) REFERENCES outfits(IdOutfit),
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone),
    PRIMARY KEY (IdOutfitZone)
);

CREATE TABLE IF NOT EXISTS Equipment_Zone(
    IdEquipmentZone INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdEquipm INT,
    IdZone INT,
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    FOREIGN KEY (IdZone) REFERENCES zones(IdZone),
    PRIMARY KEY (IdEquipmentZone)
);
    
CREATE TABLE IF NOT EXISTS Trump_Equipment(
	IdTrumpEquipment INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdTrump INT,
    IdEquipm INT,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdTrumpEquipment)
);

CREATE TABLE IF NOT EXISTS Equipment_Modifier(
	IdEquipmMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdMod INT,
    IdEquipm INT,
    FOREIGN KEY (IdMod) REFERENCES modifiers(IdMod),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdEquipmMod)
);

CREATE TABLE IF NOT EXISTS Character_Buff(
    IdCharacterBuff INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdCharacter INT,
    IdBuff INT,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdBuff) REFERENCES buffs(IdBuff),
    PRIMARY KEY(IdCharacterBuff)
);

CREATE TABLE IF NOT EXISTS Buff_Modifier(
	IdBuffMod INT NOT NULL AUTO_INCREMENT UNIQUE,
    ModifierValue INT NOT NULL DEFAULT 0,
    IdMod INT,
    IdBuff INT,
    CHECK(ModifierValue>=0),
    FOREIGN KEY (IdMod) REFERENCES modifiers(IdMod),
    FOREIGN KEY (IdBuff) REFERENCES buffs(IdBuff),
    PRIMARY KEY(IdBuffMod)
);

CREATE TABLE IF NOT EXISTS Race_Trump(
	IdRaceTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdTrump INT,
    IdRace INT,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump),
    FOREIGN KEY (IdRace) REFERENCES races(IdRace),
    PRIMARY KEY(IdRaceTrump)
);

CREATE TABLE IF NOT EXISTS Race_Class(
    IdRaceClass INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdRace INT,
    IdClass INT,
    FOREIGN KEY (IdRace) REFERENCES races(IdRace),
    FOREIGN KEY (IdClass) REFERENCES classes(IdClass),
    PRIMARY KEY(IdRaceClass)
);

CREATE TABLE IF NOT EXISTS Character_Specialization(
	IdCharSpec INT NOT NULL AUTO_INCREMENT UNIQUE ,
    IdCharacter INT,
    IdSpec INT,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec),
    PRIMARY KEY(IdCharSpec)
);

CREATE TABLE IF NOT EXISTS Specialization_Trump(
	IdSpecTrump INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdTrump INT,
    IdSpec INT,
    FOREIGN KEY (IdTrump) REFERENCES trumps(IdTrump),
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec),
    PRIMARY KEY(IdSpecTrump)
);

CREATE TABLE IF NOT EXISTS Specialization_Skill(
    IdSpecializationSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdSpec INT,
    IdSkill INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdSpec) REFERENCES specializations(IdSpec),
    PRIMARY KEY(IdSpecializationSkill)
);

CREATE TABLE IF NOT EXISTS Roll_Skill(
    IdRollSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdRoll INT,
    IdSkill INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdRoll) REFERENCES rolls(IdRoll),
    PRIMARY KEY(IdRollSkill)
);

CREATE TABLE IF NOT EXISTS Action_Skill(
    IdActionSkill INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdAction INT,
    IdSkill INT,
    FOREIGN KEY (IdSkill) REFERENCES skills(IdSkill),
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    PRIMARY KEY(IdActionSkill)
);

CREATE TABLE IF NOT EXISTS Round_Action(
	IdRoundAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdRound INT,
    IdAction INT,
    FOREIGN KEY (IdRound) REFERENCES rounds(IdRound),
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    PRIMARY KEY(IdRoundAction)
);

CREATE TABLE IF NOT EXISTS Character_Quest(
    IdCharacterQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdQuest INT,
    IdCharacter INT,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest),
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    PRIMARY KEY(IdCharacterQuest)
);

CREATE TABLE IF NOT EXISTS Character_Action(
	IdCharacterAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT,
    IdAction INT,
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    PRIMARY KEY(IdCharacterAction)
);

CREATE TABLE IF NOT EXISTS Treasure_Quest(
    IdTreasureQuest INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdQuest INT,
    IdTreasure INT,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest),
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    PRIMARY KEY(IdTreasureQuest)
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
);

CREATE TABLE IF NOT EXISTS Character_Equipment(
    IdCharacterEquipm INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdCharacter INT,
    IdEquipm INT,
    Amount INT NOT NULL,
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter),
    FOREIGN KEY (IdEquipm) REFERENCES equipments(IdEquipm),
    PRIMARY KEY(IdCharacterEquipm)
);

CREATE TABLE IF NOT EXISTS Treasure_Field(
    IdTreasureField INT NOT NULL AUTO_INCREMENT UNIQUE,
	IdField INT,
    IdTreasure INT,
    FOREIGN KEY (IdField) REFERENCES fields(IdField),
    FOREIGN KEY (IdTreasure) REFERENCES treasures(IdTreasure),
    PRIMARY KEY(IdTreasureField)
);

CREATE TABLE IF NOT EXISTS Quest_Action(
	IdQuestAction INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdQuest INT,
    IdAction INT,
    FOREIGN KEY (IdQuest) REFERENCES quests(IdQuest),
    FOREIGN KEY (IdAction) REFERENCES actions(IdAction),
    PRIMARY KEY(IdQuestAction)
);
