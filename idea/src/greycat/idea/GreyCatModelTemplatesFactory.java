/**
 * Copyright 2017 The GreyCat Authors.  All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package greycat.idea;

import com.intellij.ide.fileTemplates.FileTemplateDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;

import java.io.File;

public class GreyCatModelTemplatesFactory {

    public enum Template {
        MetaModel("GreyCatModel");
        final String file;

        Template(String file) {
            this.file = file;
        }

        public String getFile() {
            return file;
        }
    }

    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        String title = "GreyCatModel file templates";
        final FileTemplateGroupDescriptor group =
                new FileTemplateGroupDescriptor(title, GreyCatModelIcons.KEVS_ICON_16x16);

        for (Template template : Template.values()) {
            group.addTemplate(new FileTemplateDescriptor(template.getFile(), GreyCatModelIcons.KEVS_ICON_16x16));
        }

        return group;
    }

    public static PsiElement createFromTemplate(PsiDirectory directory, String fileName, Template template, String text2) {

        final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());

        if ((new File(fileName)).exists()) {
            throw new RuntimeException("File already exists");
        }

        final PsiFile file = factory.createFileFromText(fileName, GreyCatLanguageType.INSTANCE, text2);

        return directory.add(file);
    }
}
