package course02.topic02.hw;

public class Character {
    private String name;
    private int value;

    public Character(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }
}

class Nobility extends Character {
    public Nobility(int value) {
        super("Благородство", value);
    }
}

class Honour extends Character {
    public Honour(int value) {
        super("Честь", value);
    }
}

class Bravery extends Character {
    public Bravery(int value) {
        super("Храбрость", value);
    }
}

class Industriousness extends Character {
    public Industriousness(int value) {
        super("Трудолюбие", value);
    }
}

class Loyalty extends Character {
    public Loyalty(int value) {
        super("Верность", value);
    }
}

class Honesty extends Character {
    public Honesty(int value) {
        super("Честность", value);
    }
}

class Smart extends Character {
    public Smart(int value) {
        super("Умище", value);
    }
}

class Wisdom extends Character {
    public Wisdom(int value) {
        super("Мудрость", value);
    }
}

class Wit extends Character {
    public Wit(int value) {
        super("Остроумие", value);
    }
}

class Creation extends Character {
    public Creation(int value) {
        super("Творчество", value);
    }
}

class Cunning extends Character {
    public Cunning(int value) {
        super("Хитрость", value);
    }
}

class Determination extends Character {
    public Determination(int value) {
        super("Решительность", value);
    }
}

class Ambition extends Character {
    public Ambition(int value) {
        super("Амбициозность", value);
    }
}

class Resourcefulness extends Character {
    public Resourcefulness(int value) {
        super("Находчивость", value);
    }
}

class PowerLust extends Character {
    public PowerLust(int value) {
        super("Жажда власти", value);
    }
}


