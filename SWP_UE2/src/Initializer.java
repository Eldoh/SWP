import java.util.HashMap;

public class Initializer {

    private HashMap<String, WeaponPrototype> weaponMap = new HashMap<>();
    private HashMap<String, ArmorPrototype> armorMap = new HashMap<>();
    private static Initializer initializer;

    protected Initializer(){
        System.out.println("Loading Weapon Config ...");
        System.out.println("------------------------------");
        //load the file

        weaponMap.put("Sword", new WeaponPrototype("Sword", "Generic Sword",4,2, 0));
        weaponMap.put("Spear", new WeaponPrototype("Spear","Generic Spear",4,4, 0));
        weaponMap.put("Bow", new WeaponPrototype("Bow", "Generic Bow",4,10, 0));
        weaponMap.put("Shield", new WeaponPrototype("Shield", "Generic Shield",1,1, 10));


        System.out.println("Loading Armor Config ...");
        System.out.println("------------------------------");
        //load the file

        armorMap.put("Head", new ArmorPrototype("Head", "Generic Head", 3, 2));
        armorMap.put("Chest", new ArmorPrototype("Chest", "Generic Chest", 5, 4));
        armorMap.put("Legs", new ArmorPrototype("Legs", "Generic Legs", 4, 3));
        armorMap.put("Boots", new ArmorPrototype("Boots", "Generic Boots", 2, 1));
    }

    public static Initializer getInstance(){
        if(initializer == null){
            initializer = new Initializer();
        }
        return initializer;
    }

    public HashMap<String, WeaponPrototype> getWeaponMap() {
        return weaponMap;
    }

    public HashMap<String, ArmorPrototype> getArmorMap() {
        return armorMap;
    }
}
