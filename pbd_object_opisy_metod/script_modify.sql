DROP TABLE IF EXISTS Character_Level;
 
CREATE TABLE IF NOT EXISTS Character_Level(
    IdCharacterLevel INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    Level INT NOT NULL DEFAULT 0,
    Strength INT NOT NULL DEFAULT 0,
    Ability INT NOT NULL DEFAULT 0,
    Construction INT NOT NULL DEFAULT 0,
    Intellect INT NOT NULL DEFAULT 0,
    Prudence INT NOT NULL DEFAULT 0,
    Charisma INT NOT NULL DEFAULT 0,
    BaseHP INT NOT NULL DEFAULT 0,
    BaseDamage INT NOT NULL DEFAULT 0,
    
    PRIMARY KEY(IdCharacterLevel),
    
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO Character_Level (IdCharacter, Level, Strength, Ability, Construction, Intellect, 
    Prudence, Charisma, BaseHP, BaseDamage)
SELECT IdCharacter, Level, Strength, Ability, Construction, Intellect, 
    Prudence, Charisma, BaseHP, BaseDamage
FROM characters;

ALTER TABLE Character_Level 
ADD PRIMARY KEY(IdCharacterLevel);

ALTER TABLE RoundSummary
    ADD IdCharacterLevel INT NOT NULL DEFAULT 0;
ALTER TABLE RoundSummary ADD CONSTRAINT fk_grade_id 
    FOREIGN KEY (IdCharacterLevel) REFERENCES Character_Level(IdCharacterLevel);

UPDATE RoundSummary
SET IdCharacterLevel = (
    SELECT IdCharacterLevel
    FROM Character_Level
    WHERE IdCharacter = RoundSummary.IdCharacter
);


ALTER TABLE characters
    ADD IdCharacterLevel INT NOT NULL DEFAULT 0;
ALTER TABLE characters ADD CONSTRAINT fk_grade_id 
    FOREIGN KEY (IdCharacterLevel) REFERENCES Character_Level(IdCharacterLevel);

UPDATE characters
SET IdCharacterLevel = (
    SELECT IdCharacterLevel
    FROM Character_Level
    WHERE IdCharacter = characters.IdCharacter
);



SHOW CREATE TABLE RoundSummary;
ALTER TABLE RoundSummary
DROP FOREIGN KEY RoundSummary_ibfk_3;
ALTER TABLE RoundSummary
DROP COLUMN IdCharacter;


ALTER TABLE characters
DROP COLUMN Level;
ALTER TABLE characters
DROP COLUMN Strength;
ALTER TABLE characters
DROP COLUMN Ability;
ALTER TABLE characters
DROP COLUMN Construction;
ALTER TABLE characters
DROP COLUMN Intellect;
ALTER TABLE characters
DROP COLUMN Prudence;
ALTER TABLE characters
DROP COLUMN Charisma;
ALTER TABLE characters
DROP COLUMN BaseHP;
ALTER TABLE characters
DROP COLUMN BaseDamage;