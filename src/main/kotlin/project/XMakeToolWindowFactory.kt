package project

import com.intellij.execution.ui.ConsoleView
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.ui.content.ContentFactory

class XMakeToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        // add output tab/panel
        val toolwindowOutputPanel = XMakeToolWindowOutputPanel(project)
        val outputTab = ContentFactory.SERVICE.getInstance().createContent(toolwindowOutputPanel, "Output", false)
        toolWindow.contentManager.addContent(outputTab)

        // add problem tab/panel
        val toolwindowProblemPanel = XMakeToolWindowProblemPanel(project)
        val problemTab = ContentFactory.SERVICE.getInstance().createContent(toolwindowProblemPanel, "Problem", false)
        toolWindow.contentManager.addContent(problemTab)

        // show the output panel by default
        toolWindow.contentManager.setSelectedContent(outputTab)
    }
}


// the xmake tool windows
val Project.xmakeToolWindow: ToolWindow?
    get() = ToolWindowManager.getInstance(this).getToolWindow("XMake")

// the xmake output panel
val Project.xmakeOutputPanel: XMakeToolWindowOutputPanel
    get() = this.xmakeToolWindow?.contentManager?.getContent(0)?.component as XMakeToolWindowOutputPanel

// the xmake problem panel
val Project.xmakeProblemPanel: XMakeToolWindowProblemPanel
    get() = this.xmakeToolWindow?.contentManager?.getContent(1)?.component as XMakeToolWindowProblemPanel

// the xmake console view
val Project.xmakeConsoleView: ConsoleView
    get() = this.xmakeOutputPanel.consoleView

