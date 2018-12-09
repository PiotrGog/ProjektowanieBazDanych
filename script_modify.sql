DROP TABLE IF EXISTS Character_Level;
 
CREATE TABLE IF NOT EXISTS Character_Level(
    IdCharacterLevel INT NOT NULL AUTO_INCREMENT UNIQUE,
    IdCharacter INT NOT NULL,
    Level INT NOT NULL DEFAULT 0,
    Strength INT NOT NULL DEFAULT 0,
    Ability INT NOT NULL DEFAULT 0,
    Contruction INT NOT NULL DEFAULT 0,
    Intellect INT NOT NULL DEFAULT 0,
    Prudence INT NOT NULL DEFAULT 0,
    Charisma INT NOT NULL DEFAULT 0,
    
    PRIMARY KEY(IdCharacterLevel),
    
    FOREIGN KEY (IdCharacter) REFERENCES characters(IdCharacter)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);