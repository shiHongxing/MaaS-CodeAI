
package com.ai.settings;

import com.ai.chat.models.ModelFamily;
import com.ai.chat.models.ModelType;
import com.ai.i18n.Bundle;
import com.intellij.openapi.options.Configurable;

import java.util.function.Predicate;

import static com.ai.chat.AssistantType.System.LanyunMaaS;

public class LanyunMaaSPanel extends BaseModelPanel implements Configurable {
    private static final Predicate<ModelType> LanyunMaasModels = model -> model.getFamily() == ModelFamily.LANYUN_MAAS;

    public LanyunMaaSPanel() {
        super(LanyunMaaS, LanyunMaasModels);
    }

    @Override
    public String getDisplayName() {
        return Bundle.get("ui.setting.menu.text");
    }

    @Override
    protected boolean isModelNameEditable() {
        return true;
    }

    @Override
    protected boolean isStreamOptionsApiAvailable() {
        return true;
    }
}
