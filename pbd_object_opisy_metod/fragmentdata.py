import random

# with open('races.txt', encoding='latin-1') as f:
#     RACES_NAME_DESCR = f.read().splitlines()

# races = []
# races_name = "{"
# for race in RACES_NAME_DESCR:
#     race = race.split(';')
#     print("case \"" + race[0] + "\":\nreturn new Race(\""+race[0]+"\", \""+race[1]+"\"," + str(random.randint(1, 15)) + ", " + str(random.randint(1, 15)) + ", " + str(random.randint(1, 15))+  ", " + str(random.randint(1, 15))+  ", " + str(random.randint(1, 15)) +  ", " + str(random.randint(1, 15)) + ");")
#     races_name += "\""+race[0]+"\","
#     # races.append(Races(RaceName=race[0], RaceDescription=race[1]))
# races_name += "};"

# print(races_name)


# with open('classes.txt', encoding='latin-1') as f:
#     CLASSES_NAME_DESCR = f.read().splitlines()

# classes = []
# class_name = "{"
# for class_ in CLASSES_NAME_DESCR:
#     class_ = class_.split(';')
#     print("case \"" + class_[0] + "\":\nreturn new Class(\""+class_[0]+"\", \""+class_[1]+"\"," + str(random.randint(1, 15)) + ", " + str(random.randint(1, 15)) + ", " + str(random.randint(1, 15))+  ", " + str(random.randint(1, 15))+  ", " + str(random.randint(1, 15)) +  ", " + str(random.randint(1, 15)) + ");")
#     class_name += "\""+class_[0]+"\","
# class_name += "};"

# print(class_name)

with open('classes.txt', encoding='latin-1') as f:
    SCECIALIZATIONS = f.read().splitlines()

specs_name = "{"
for spec in SCECIALIZATIONS:
    spec = spec.split(':')
    print("case \"" + spec[0] + "\":\nreturn new Specialization(\""+spec[0]+"\", \""+spec[1]+"\"," + str(random.randint(1, 15)) + ", " + str(random.randint(1, 15)) + ", " + str(random.randint(1, 15))+  ", " + str(random.randint(1, 15))+  ", " + str(random.randint(1, 15)) +  ", " + str(random.randint(1, 15)) + ");")
    specs_name += "\""+spec[0]+"\","
specs_name += "};"
    # races.append(Races(RaceName=race[0], RaceDescription=race[1]))
    # print(spec)
    # spec = spec.split(':')
    # specs.append(Specializations(SpecName=spec[0], SpecDescription=spec[1]))

print(specs_name)