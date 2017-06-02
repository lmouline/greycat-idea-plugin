package greycat.idea.ecore;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.VirtualFile;
import greycat.idea.GCMLanguageType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GCM2EcoreAction extends AnAction implements DumbAware {

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        VirtualFile currentFile = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        final Presentation presentation = e.getPresentation();
        if (currentFile != null && currentFile.getName().endsWith(".ecore")) {
            presentation.setEnabledAndVisible(true);
        } else {
            presentation.setEnabledAndVisible(false);
        }
    }

    private PrettyPrinter prettyPrinter = new PrettyPrinter();

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        VirtualFile currentFile = DataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        FileDocumentManager.getInstance().saveDocument(FileDocumentManager.getInstance().getDocument(currentFile));
        String path = currentFile.getCanonicalPath();

        File origin = new File(path);
        File target = new File(path.replace("ecore", GCMLanguageType.DEFAULT_EXTENSION));
        FileWriter writer = null;
        try {
            writer = new FileWriter(target);
            prettyPrinter.prettyPrint(origin, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        currentFile.getParent().refresh(true, true);

    }

}
