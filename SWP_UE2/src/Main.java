import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Initializer loader = Initializer.getInstance();

        HashMap<String, WeaponPrototype> weaponMap = loader.getWeaponMap();
        HashMap<String, ArmorPrototype> armorMap = loader.getArmorMap();

        WeaponPrototype sword = weaponMap.get("Sword");
        WeaponPrototype clonedSword = weaponMap.get("Sword").clone();
        clonedSword.name = "Cloned Sword";
        clonedSword.dps = 5;

        System.out.println(sword.name + " / " + sword.dps);
        System.out.println(clonedSword.name + " / " + clonedSword.dps);


    }
}
