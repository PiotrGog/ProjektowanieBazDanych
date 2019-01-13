package pbd.entity;


import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Race {

    @PrimaryKey
    private String name;

    private String description;

    private int strength;

    private int ability;

    private int intellect;

    private int prudence;

    private int charisma;

    private int construction;

    public Race(String name, String description, int strength, int ability, int intellect, int prudence, int charisma,
                int construction) {
        this.name = name;
        this.description = description;
        this.setStrength(strength);
        this.setAbility(ability);
        this.setIntellect(intellect);
        this.setPrudence(prudence);
        this.setCharisma(charisma);
        this.setConstruction(construction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getPrudence() {
        return prudence;
    }

    public void setPrudence(int prudence) {
        this.prudence = prudence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConstruction() {
        return construction;
    }

    public void setConstruction(int construction) {
        this.construction = construction;
    }

    public static Race raceFactory(String raceName) {
        switch (raceName.toLowerCase()) {
            case "abiku":
                return new Race("Abiku",
                        "among the Yoruba and Dahomey people in West Africa, " +
                                "these are evil tree spirits that are born as children and " +
                                "die several times, often within the same family. " +
                                "I could be wrong, but I think the ogbanje are basically the same thing",
                        10, 4, 5, 12, 1, 4);
            case "bakru":
                return new Race("Bakru",
                        "these little gnome-like people in Suriname are half flesh and half wood. " +
                                "They will do your dirty work for you if you enter into a pact " +
                                "with them which is a terrible idea",
                        9, 1, 2, 4, 9, 15);
            case "banshee":
                return new Race("Banshee",
                        "if youre about to die, this Irish female spirit will show up to wail at you. " +
                                "The Slavic božalość are pretty much the same thing",
                        9, 1, 5, 10, 1, 5);
            case "barghests":
                return new Race("Barghests",
                        "giant demonic dogs with huge teeth and claws who live in northern England. " +
                                "One shows up when youre about to die. Some creatures like this are simply " +
                                "referred to as Black Dogs.",
                        8, 12, 1, 5, 2, 8);
            case "basilisks":
                return new Race("Basilisks",
                        "these reptiles can kill a person with a single glance. " +
                                "Sometimes people call them cockatrices",
                        9, 2, 10, 2, 5, 1);
            case "brownies":
                return new Race("brownies",
                        "in England and Scotland, these are little people who are loyal to human " +
                                "households and will sometimes help out with the chores. You donât want to make " +
                                "them mad, though. Harry Potter fans, take note: a dobbie or dobie is a kind of " +
                                "brownie, and an angry brownie can turn into a boggart.",
                        1, 4, 6, 5, 5, 13);
            case "btsan":
                return new Race("btsan",
                        "the btsan are fierce sky spirits in Tibet that look like red hunters riding " +
                                "red horses.", 5, 12, 10, 2, 4, 2);
            case "Cerberus":
                return new Race("Cerberus",
                        "a three-headed dog that guards the door of the Underworld in Greek mythology.",
                        12, 12, 4, 6, 12, 12);
            case "chimera":
                return new Race("chimera",
                        "this monstrous beast of ancient Greece has the body and head of a lion," +
                                " a goats head sticking out of its back, a set of goat-udders just for " +
                                "fun, and a serpentine tail.",
                        1, 4, 6, 15, 3, 13);
            case "changeling":
                return new Race("changeling",
                        "many European countries have stories about the fairies or trolls stealing " +
                                "human babies and leaving sickly or malignant magical babies in their place." +
                                " These myths have some similarities with the abiku, above.",
                        3, 2, 10, 15, 9, 5);
            case "Cloud People":
                return new Race("Cloud People",
                        "also known as the Shiwanna. In Pueblo Native American traditions, these " +
                                "are supernatural beings from the underworld who bring rainfall.",
                        15, 13, 6, 10, 14, 13);
            case "Co-hon":
                return new Race("Co-hon",
                        "in Vietnam, these are the spirits of people who died a violent death " +
                                "and werenât buried with ceremony. They bring bad luck to people who pass" +
                                " by them unless they are appeased.",
                        14, 15, 15, 5, 5, 7);
            case "Coraniaid":
                return new Race("Coraniaid",
                        "the Coraniaid are Welsh dwarves with very sharp hearing who are immune " +
                                "to weapons. They use fairy money, which looks legit but soon turns into toadstools.",
                        2, 8, 2, 9, 12, 4);
            case "Cwn Annwn":
                return new Race("Cwn Annwn",
                        "Welsh hellhounds. Theyre white with red ears, and gather up souls and " +
                                "drag them to hell. (See also: Dandos Dogs.)",
                        7, 5, 9, 9, 4, 2);
            case "dÃ¦mons":
                return new Race("dÃ¦mons",
                        "(also spelled daimons.) These not the same thing as demons. " +
                                "In ancient Greek mythology, they were helpful spirit guides, " +
                                "similar to guardian angels.",
                        9, 8, 5, 12, 6, 10);
            case "demons":
                return new Race("demons",
                        "obviously you know about these guys. Variations of them appear in " +
                                "ancient near East religions, Judaism, Hinduism, Islam, Christianity, " +
                                "and other faiths. Hereâs a fun list of some of the worst ones, and a hereâs " +
                                "a list of many or all of the demons with names.",
                        7, 7, 1, 9, 5, 10);
            case "dodore":
                return new Race("dodore",
                        "these are little people in the Solomon Islands have one eye, one leg, " +
                                "and long red hair, and they dont seem to be friendly.",
                        3, 14, 12, 2, 5, 2);
            case "djinn":
                return new Race("djinn",
                        "these are supernatural beings of Arabian mythology who can be conjured " +
                                "up for aid. However, they are malicious tricksters and shape shifters. " +
                                "There are a few different classes of djinn, including the afrit " +
                                "(also spelled ifrit), who are large beings made out of smoke.",
                        12, 3, 9, 13, 5, 5);
            case "dracae":
                return new Race("dracae",
                        "singular drac. These weirdo water spirits in England take the form of " +
                                "floating wooden dishes. If women passing by think, Yay! Free dishes! " +
                                "and try to grab one, the dracae drag her under the water and make her " +
                                "their nanny forever.",
                        4, 8, 6, 15, 4, 1);
            case "dragons":
                return new Race("dragons", "they appear in the mythologies of Europe, " +
                        "the Middle East, and Asia.", 10,
                        10, 9, 4, 15, 5);
            case "dryads":
                return new Race("dryads", "tree nymphs in Greek mythology.",
                        11, 9, 8, 5, 8, 2);
            case "dwarves":
                return new Race("dwarves",
                        "most of them come from Norse mythology, but there are also Teutonic dwarves,  " +
                                "Slavic dwarves, Welsh dwarves (see the Coraniaid, above), and other kinds. " +
                                "Dwarves are almostalways miners and/or smiths who live underground.",
                        5, 14, 6, 6, 2, 9);
            case "duende":
                return new Race("duende",
                        "the Spanish word âduendeâve read plenty of Federico Garcia Lorca. However, " +
                                "the duende are also pixie-like creatures who may either get you lost in the " +
                                "forest, or help you find your way home, depending on the story. In some other tales, " +
                                "they hide in the walls or under your bed, accidentally cut off kidsâ toes in attempts " +
                                "to clip their toenails, or just give people nightmares.",
                        5, 1, 7, 10, 12, 15);
            case "elves":
                return new Race("elves",
                        "there are so many different kinds. This link discusses the Ã¡lfar (singular, " +
                                "Ã¡lfr)  light-elves in Norse Germanic mythology, which clearly inspired Tolkien " +
                                " as well as someother types.",
                        2, 4, 11, 1, 4, 12);
            case "emandwa":
                return new Race("emandwa",
                        "these protective household spirits in Uganda are loyal to families and help " +
                                "women to be fertile.",
                        13, 9, 14, 14, 14, 14);
            case "encantados":
                return new Race("encantados",
                        "in Brazil, this can refer to shape-shifting dolphin men who live in an underwater " +
                                "realm. In the vodou religion, the word has a different meaning.",
                        10, 13, 12, 15, 9, 12);
            case "fairies":
                return new Race("fairies",
                        "dozens and maybe hundreds of cultures across the world have myths about magical," +
                                " tricksy little people, a few of which are called out separately on this list. " +
                                "Here are links to read about English fairies, Irish fairies, and fairies " +
                                "on the Isle of Man. Thereâs some discussion of Italian fairies, or fatas, " +
                                "in this article about Italian witchcraft.",
                        10, 1, 11, 1, 11, 3);
            case "fauns":
                return new Race("fauns",
                        "C.S. Lewis may have introduced you to these half-human, half-goat forest pals. " +
                                "They are Roman in origin, and this article discusses the difference between " +
                                "fauns and satyrs.",
                        1, 11, 7, 2, 11, 9);
            case "firebird":
                return new Race("firebird", "in Russian mythology, this bird has feathers " +
                        "that glow in the night.", 2,
                        4, 15, 15, 11, 10);
            case "flagae":
                return new Race("flagae",
                        "this spirits have their roots in medieval Europe. If you are a witch, " +
                                "you can make them show up in your mirror and tell you about the future.",
                        10, 12, 4, 10, 5, 1);
            case "fuaths":
                return new Race("fuaths",
                        "these ugly little jerks live in bodies of water in Scotland and play " +
                                "tricks on you or try to sink your boat. You can kill them with sunlight or steel.",
                        14, 8, 2, 14, 11, 12);
            case "gahe":
                return new Race("gahe",
                        "also known as the Mountain People, because they live inside mountains." +
                                " According to Apache beliefs, these spirits have healing powers.",
                        12, 13, 2, 8, 7, 14);
            case "ganas":
                return new Race("ganas",
                        "in Hindu mythology, these are different kinds of supernatural beings " +
                                "in Lord Shivaâs entourage (though Ganesha, the elephant-headed god, is their boss.)",
                        1, 14, 10, 3, 11, 9);
            case "gandharvas":
                return new Race("gandharvas",
                        "Gandharvas are male nature spirits who are, among many other things," +
                                " wonderful singers and musicians. They figure in both Hindu and Buddhist mythology.",
                        8, 8, 1, 6, 14, 2);
            case "gnomes":
                return new Race("gnomes",
                        "they are somewhat similar to dwarves, but they donât live underground," +
                                " and they wear cute peaked red hats.",
                        11, 15, 13, 5, 6, 2);
            case "goblins":
                return new Race("goblins",
                        "these European creatures can be very short or human-sized, and they are" +
                                " as ugly as they are mean.",
                        4, 11, 10, 11, 2, 6);
            case "gremlins":
                return new Race("gremlins",
                        "the British Royal Air Force blamed equipment failures and such on magical " +
                                "troublemakers called gremlins, but they were just as likely boggarts or goblins.",
                        11, 4, 14, 4, 12, 7);
            case "gryphons":
                return new Race("gryphons",
                        "also spelled griffins. They have the head, talons, and wings of an eagle " +
                                "and the body of a lion.",
                        5, 12, 3, 8, 14, 13);
            case "hag":
                return new Race("hag",
                        "in some European tales, a hag is a supernatural being that takes the form" +
                                " of a crone. Some hags sit on people when theyre sleeping and give them nightmares.",
                        5, 1, 2, 10, 14, 7);
            case "harpies":
                return new Race("harpies",
                        "in Greek and Roman mythology, these are vengeful wind spirits. They have " +
                                "the heads and torsos of ugly women, long talons, and bird bodies.",
                        7, 13, 6, 8, 15, 8);
            case "Hesperides":
                return new Race("Hesperides",
                        "these Greek nymphs are associated with the light of sunset, and they " +
                                "guard a sacred tree of golden apples.",
                        10, 10, 2, 14, 13, 7);
            case "hobgoblin":
                return new Race("hobgoblin", "like a brownie, but more into playing practical " +
                        "jokes.", 8, 4, 8, 3, 12,
                        9);
            case "hongaek":
                return new Race("hongaek",
                        "this Korean word means Red Disaster, and describes a cloud of fear and " +
                                "confusion that shows up at the scene of a suicide, murder, fatal traffic " +
                                "accident, or other catastrophes. The cloud infects people and brings them bad luck.",
                        1, 13, 11, 7, 1, 9);
            case "hu hsien":
                return new Race("hu hsien",
                        "in Chinese mythology, these are shapeshifting foxes who turn into gorgeous" +
                                " women.", 8, 11, 8,
                        8, 4, 5);
            case "hydra":
                return new Race("hydra",
                        "the terrorist organization in Marvel Comics is named after an ancient " +
                                "sea monster in Greek and Roman mythology. It has many heads, and if you cut" +
                                " one off, it grows two more in its place.",
                        14, 8, 13, 6, 11, 6);
            case "hyter sprites":
                return new Race("hyter sprites",
                        "awwwwâ¦ these green-eyed fairies in East Anglia, England can shapeshift " +
                                "into sand martins, and they help lost children get home.",
                        5, 1, 7, 8, 7, 3);
            case "igigi":
                return new Race("igigi",
                        "in the mythology of ancient Mesopotamia, these spirits hovered above " +
                                "the earths horizon and, like angels, helped the deities.",
                        12, 3, 7, 4, 12, 5);
            case "incubi":
                return new Race("incubi",
                        "these are male evil spirits that have sex with women while they are" +
                                " sleeping and impregnate them. In medieval England, an incubus can shapeshift" +
                                " to look just like a womanâshusband or lover. However, in his natural state," +
                                " he has cloven hooves. In a few variations, the incubus can take a male or a " +
                                "female form. Many cultures have their own version of the incubus.",
                        4, 11, 6, 8, 14, 1);
            case "javerzaharses":
                return new Race("javerzaharses",
                        "these Armenian nymphs sometimes have wings. Their name means The Perpetual" +
                                " Brides, and they are involved with planning wedding ceremonies.",
                        10, 15, 13, 13, 4, 11);
            case "kaches":
                return new Race("kaches",
                        "in Armenian tales, these mean spirits hide in rocks and trap and torture " +
                                "humans.", 4, 2, 5, 5,
                        6, 2);
            case "kakamora":
                return new Race("kakamora",
                        "in the Solomon Islands, these little people have long hair, long teeth, " +
                                "and long nails. They hide in caves and banyan trees, and either eat people " +
                                "or play tricks on them,depending on who you talk to.",
                        3, 12, 5, 12, 14, 12);
            case "kanaima":
                return new Race("kanaima", "in Guinia, these avenging spirits can possess " +
                        "people.", 5, 9, 6, 1, 5, 2);
            case "kitsune":
                return new Race("kitsune", "âkitsuneât get any cooler than that. They appear " +
                        "in Romani folklore.", 1, 9,
                        8, 9, 15, 11);
            case "kobolds":
                return new Race("kobolds",
                        "these little German guys might live in mines or in your house. They " +
                                "have similarities to brownies and to dwarves.",
                        10, 9, 14, 7, 1, 7);
            case "Korrigan":
                return new Race("Korrigan",
                        "in northwestern France, these elf-like female beings have long hair, " +
                                "flowing white garments, and sometimes delicate wings. Their songs and " +
                                "firelit dances can lead travelers astray.",
                        4, 3, 2, 10, 14, 5);
            case "knockers":
                return new Race("knockers",
                        "also called Tommyknockers, these mine spirits live in Cornwall and " +
                                "sometimes in the U.S. (I believe some emigrated). They are similar to " +
                                "kobolds and to dwarves.",
                        14, 7, 12, 9, 6, 15);
            case "leprechauns":
                return new Race("leprechauns",
                        "these famous little bearded shoemakers in Irish tales sometimes hide  " +
                                "pots of gold at the end of rainbows.",
                        5, 9, 12, 5, 12, 14);
            case "limoneads":
                return new Race("limoneads",
                        "I know, it looks like lemonheads. These ancient Greek nymphs protected " +
                                "meadows and fields of flowers.",
                        6, 10, 1, 13, 8, 8);
            case "ma-mo":
                return new Race("ma-mo", "female disease demons in Tibet who dress entirely " +
                        "in black.",
                        12, 6, 1, 8, 3, 14);
            case "matabiri":
                return new Race("matabiri", "nasty swamp spirits in Papua New Guinea.",
                        3, 12, 9, 7, 7, 12);
            case "matagaigai":
                return new Race("matagaigai",
                        "malevolent tree spirits, also in Papua New Guinea. The females have " +
                                "one big breast and one small one.",
                        10, 14, 15, 4, 15, 3);
            case "mermaids and mermen":
                return new Race("mermaids and mermen",
                        "dozens of cultures have myths about these half-human, half-fish creatures.",
                        2, 13, 1, 4, 15, 5);
            case "minotaur":
                return new Race("minotaur",
                        "in Greek mythology, this monster with the head of a bull " +
                                "lived in a maze and required regular sacrifices of young people to feed his hunger.",
                        15, 12, 1, 7, 12, 15);
            case "moksin tongbop":
                return new Race("moksin tongbop",
                        "in Korea, these wood imps can hide in an armload of firewood and" +
                                " come into your house, where they will cause disease and misfortune.",
                        3, 3, 6, 8, 5, 14);
            case "muses":
                return new Race("muses",
                        "in Greek mythology, these nine nymphs or goddesses are patronesses of the arts.",
                        8, 13, 15, 2, 11, 12);
            case "nats":
                return new Race("nats",
                        "these tree spirits, sometimes worshipped in parts of Myanmar," +
                                " may guard the environment.",
                        3, 12, 14, 15, 2, 4);
            case "nixies":
                return new Race("nixies", "water spirits in Germany, Scandinavia, and Switzerland.",
                        13, 2, 3, 10, 2, 11);
            case "norns":
                return new Race("norns", "also called the nornir, these are the " +
                        "three Fates in Norse mythology.",
                        14, 3, 9, 9, 13, 13);
            case "phoenix":
                return new Race("phoenix",
                        "this long-lived bird stars in the mythologies of several ancient cultures. " +
                                "After hundreds of years, he spontaneously combusts, and a new baby phoenix" +
                                " is born in the ashes.",
                        11, 15, 14, 11, 3, 9);
            case "pixies":
                return new Race("pixies", "red-haired fairies from Cornwall," +
                        " England, with turned-up noses like pigs.",
                        15, 13, 12, 4, 5, 14);
            case "poltergeists":
                return new Race("poltergeists",
                        "spirits of the dead or malignant forces that live in some houses " +
                                "and throw things around. The name means noise spirit in German.",
                        7, 3, 14, 4, 15, 8);
            case "saba-leippya":
                return new Race("saba-leippya",
                        "this is actually a sub-category of nats (see above), but they are so " +
                                "lovely I had to call them out specifically. They are guardian spirits of rice paddies." +
                                " One is assigned to each field, and they take the form of butterflies.",
                        11, 3, 11, 2, 2, 7);
            case "salamanders":
                return new Race("salamanders",
                        "these are real lizards, but they also have legends associated with them. " +
                                "European medieval philosophers said that salamanders could create and put out fires.",
                        8, 3, 11, 11, 10, 8);
            case "selkies":
                return new Race("selkies",
                        "most cultures have shapeshifter stories. In Orkney, " +
                                "the selkies are seals who can turn into humans.",
                        14, 9, 11, 7, 13, 4);
            case "skinwalkers":
                return new Race("skinwalkers",
                        "in Navajo mythology, a skinwalker can take on the appearance of any " +
                                "person or creature, and they can be terrifying. This link is scary and NSFW.",
                        11, 4, 13, 10, 2, 10);
            case "Sphinx":
                return new Race("Sphinx",
                        "in Greek and Egyptian stories, the Sphinx is a creature with a human head " +
                                "and a lionâs body who likes to ask people riddles, and then eat them if they " +
                                "donât know the answer.",
                        7, 15, 13, 6, 15, 8);
            case "succubi":
                return new Race("succubi", "in European tales, these female demons have sex" +
                        " with sleeping men.", 2, 15,
                        2, 5, 3, 10);
            case "sylphs":
                return new Race("sylphs",
                        "these elemental, delicate spirits of the air may be the souls of women who " +
                                "died as virgins. From medieval European mythology.",
                        14, 8, 1, 5, 1, 14);
            case "trolls":
                return new Race("trolls",
                        "unlike Internet trolls, mythological trolls of Scandinavia and England are " +
                                "useful once in a great while. Mostly theyâre malicious, and most people agree" +
                                " that theyâre hideous.",
                        1, 13, 8, 2, 13, 4);
            case "undines":
                return new Race("undines",
                        "beautiful but soulless female water spirits, according to medieval " +
                                "European tradition.",
                        12, 1, 10, 5, 2, 4);
            case "unicorns":
                return new Race("unicorns",
                        "I donât really need to explain. Click the link to find out about the " +
                                "nine times they are referenced in the Bible, among other things.",
                        2, 7, 5, 11, 7, 11);
            case "Valkyries":
                return new Race("Valkyries",
                        "finally we get to my favorites! Their name means Choosers of the Slain " +
                                "and they show up at battles to decide who will die. Then they escort the " +
                                "souls of the chosen back to Valhalla, where everyone has a good time.",
                        4, 12, 12, 1, 3, 11);
            case "vampires":
                return new Race("vampires",
                        "forget about sparkling  in all the old stories, vampires are beyond " +
                                "disgusting. This site has a pretty good breakdown of vampires and vampire-like " +
                                "creatures from different cultures. Most of our modern vampire lore comes from " +
                                "early 18th century Eastern Europe, when everyone lost their minds, claimed to " +
                                "see vampires, and tried to stake and kill them. (You can read aboutone case here.) " +
                                "The vampires in Romanian mythology are called the strigoi.",
                        14, 11, 3, 3, 15, 5);
            case "veela":
                return new Race("veela",
                        "Also spelled vila. These ladies are beautiful mountain nymphs of Serbia who " +
                                "like to dance in the forest under the light of the moon.",
                        7, 8, 8, 13, 8, 13);
            case "wendigos":
                return new Race("wendigos",
                        "in Native American mythology, these giant creatures was once human, but turned " +
                                "into lanky, hairy monsters after they resorted to cannibalism. They roam the woods" +
                                " looking for more people to eat.",
                        14, 2, 8, 11, 7, 6);
            case "werewolves":
                return new Race("werewolves",
                        "wolves are some of the most common kinds of shapeshifters in folklore. Heres " +
                                "a pretty comprehensive werewolf site, and you can read about Louisianas" +
                                " loup-garou here.",
                        6, 8, 12, 14, 7, 5);
            case "winged horses":
                return new Race("winged horses",
                        "there are many of them, from a few different cultures, besides the famous Pegasus.",
                        2, 14, 2, 4, 10, 2);
            default:
                return null;
        }
    }


//    String[] listRaces =
//            {"abiku", "angels", "bakru", "banshee", "barghests", "basilisks", "brownies", "btsan", "Cerberus",
//                    "chimera", "changeling", "Cloud People", "Co-hon", "Coraniaid", "Cwn Annwn", "dÃ¦mons", "demons",
//                    "dodore", "djinn", "dracae", "dragons", "dryads", "dwarves", "duende", "elves", "emandwa",
//                    "encantados", "fairies", "fauns", "firebird", "flagae", "fuaths", "gahe", "ganas", "gandharvas",
//                    "gnomes", "goblins", "gremlins", "gryphons", "hag", "harpies", "Hesperides", "hobgoblin", "hongaek",
//                    "hu hsien", "hydra", "hyter sprites", "igigi", "incubi", "javerzaharses", "kaches", "kakamora",
//                    "kanaima", "kitsune", "kupua", "keshalyi", "kobolds", "Korrigan", "knockers", "leprechauns",
//                    "limoneads", "ma-mo", "matabiri", "matagaigai", "mermaids and mermen", "minotaur", "moksin tongbop",
//                    "muses", "nats", "nixies", "norns", "phoenix", "pixies", "poltergeists", "saba-leippya",
//                    "salamanders", "selkies", "skinwalkers", "Sphinx", "succubi", "sylphs", "trolls", "undines",
//                    "unicorns", "Valkyries", "vampires", "veela", "wendigos", "werewolves", "winged horses"};


}
