package differents;

import java.util.prefs.Preferences;

public class PreferencesExample {
    public static void main(String[] args) {
        Preferences user = Preferences.userRoot();
        Preferences system = Preferences.systemRoot();
        Preferences lesson = user.node("/train/differents");
        //lesson.put("1", "one");
        System.out.println(lesson.getInt("myInt",-1));
        System.out.println(lesson.get("1","def"));


    }
}
