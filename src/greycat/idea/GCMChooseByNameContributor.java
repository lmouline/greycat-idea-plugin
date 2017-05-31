package greycat.idea;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import greycat.idea.psi.GCMTypeDeclaration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GCMChooseByNameContributor implements ChooseByNameContributor {

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<GCMTypeDeclaration> properties = GCMUtil.findProperties(project);
        List<String> names = new ArrayList<String>(properties.size());
        for (GCMTypeDeclaration property : properties) {
            if (property != null && property.getName() != null && property.getName().length() > 0) {
                names.add(property.getName());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        // todo include non project items
        List<GCMTypeDeclaration> properties = GCMUtil.findProperties(project, name);
        return properties.toArray(new NavigationItem[properties.size()]);
    }
}



