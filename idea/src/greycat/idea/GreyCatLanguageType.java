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

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GreyCatLanguageType extends LanguageFileType {

    public static final GreyCatLanguageType INSTANCE = new GreyCatLanguageType();

    protected GreyCatLanguageType() {
        super(GreyCatLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GreyCatModel";
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "gcm";

    @NotNull
    @Override
    public String getDescription() {
        return "GreyCatModel is a DSL dedicated to define a typing layer on top of GreyCat";
    }

    @NotNull
    @NonNls
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GreyCatModelIcons.KEVS_ICON_16x16;
    }

    @Override
    public String getCharset(@NotNull VirtualFile file, byte[] content) {
        return CharsetToolkit.UTF8;
    }


}
