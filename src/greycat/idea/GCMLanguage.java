package greycat.idea;

import com.intellij.lang.Language;

public class GCMLanguage extends Language {

    public static final GCMLanguage INSTANCE = new GCMLanguage();

    private GCMLanguage() {
        super("GCM", "text/mm", "text/x-mm", "application/x-mm");
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }

}
