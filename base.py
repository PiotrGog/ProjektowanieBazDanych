from sqlalchemy import create_engine 
from sqlalchemy import inspect 
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.ext.automap import automap_base
from sqlalchemy.orm import Session
import pandas as pd

Base = automap_base()
engine = create_engine('mysql://root:@127.0.0.1:3306/rpg_game')
connection = engine.connect()


Base.prepare(engine, reflect=True)
print(Base.classes)

ActionSkill = Base.classes.action_skill
Actions = Base.classes.actions
Board = Base.classes.board
BuffModifier = Base.classes.buff_modifier
Buffs = Base.classes.buffs
CharacterAction = Base.classes.character_action
CharacterBuff = Base.classes.character_buff
CharacterEquipment = Base.classes.character_equipment
CharacterQuest = Base.classes.character_quest
CharacterSpecialization = Base.classes.character_specialization
CharacterZone = Base.classes.character_zone
Characters = Base.classes.characters 
Classes= Base.classes.classes
EquipmentModifer = Base.classes.equipment_modifier
Equipments = Base.classes.equipments
Fields = Base.classes.fields
Modifiers = Base.classes.modifiers
OutfitEquipment = Base.classes.outfit_equipment
OutfitZone = Base.classes.outfit_zone
Outfits = Base.classes.outfits
Quest_Action = Base.classes.quest_action
Quests = Base.classes.quests
RaceClass = Base.classes.race_class
RaceTrump = Base.classes.race_trump
Races = Base.classes.races
RollSkill = Base.classes.roll_skill
Rolls = Base.classes.rolls
RoundAction = Base.classes.round_action
Rounds = Base.classes.rounds
Skills = Base.classes.skills
SpecializationSkill = Base.classes.specialization_skill
SpecializationTrump = Base.classes.specialization_trump
Specializations = Base.classes.specializations
Teams = Base.classes.teams
TreasureEquipment = Base.classes.treasure_equipment
TreasureQuest = Base.classes.treasure_quest
Treasures = Base.classes.treasures
TrumpEquipment = Base.classes.trump_equipment
Trumps = Base.classes.trumps
Zones = Base.classes.zones

# with open('teams_names.txt') as f:
#     TEAM_NAMES = f.read().splitlines()


session = Session(engine)

# teams = []
# for team in TEAM_NAMES:
#     teams.append(Teams(TeamName=team))

# session.add_all(teams)
# session.commit()

# with open('races.txt', encoding='latin-1') as f:
#     RACES_NAME_DESCR = f.read().splitlines()


# races = []
# for race in RACES_NAME_DESCR:
#     print(race)
#     race= race.split(';')
#     races.append(Races(RaceName=race[0], RaceDescription =race[1]))

# session.add_all(races)
# session.commit()

# with open('classes.txt', encoding='latin-1') as f:
#     SCECIALIZATIONS = f.read().splitlines()


# specs = []
# for spec in SCECIALIZATIONS:
#     print(spec)
#     spec = spec.split(':')
#     specs.append(Specializations(SpecName=spec[0], SpecDescription =spec[1]))
# session.add_all(specs)
# session.commit()
# connection.close()

with open('basic_classes.txt', encoding='latin-1') as f:
    SCECIALIZATIONS = f.read().splitlines()


specs = []
for spec in SCECIALIZATIONS:
    print(spec)
    spec = spec.split(':')
    specs.append(Specializations(SpecName=spec[0], SpecDescription =spec[1]))
session.add_all(specs)
session.commit()
connection.close()

