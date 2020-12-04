package actions


import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import org.jetbrains.annotations.NotNull

class BuildAction : AnAction() {

    override fun actionPerformed(@NotNull event: AnActionEvent) {

        // the project
        val project = event.project ?: return
    }
}
