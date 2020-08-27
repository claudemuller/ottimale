package rs.dxt.ottimale

import java.awt.{AWTException, Image, SystemTray, Taskbar, Toolkit, TrayIcon}
import java.net.URL

object SysTray {
  val tray: SystemTray = SystemTray.getSystemTray
  val resource: URL = getClass.getResource("/tray-icon.png")
  val taskbar: Taskbar = Taskbar.getTaskbar
  var trayIcon: Image = _

  def init(): Unit = {
    try {
//      tray.add(new TrayIcon(trayIcon))

      if (resource != null) {
        trayIcon = Toolkit.getDefaultToolkit.getImage(resource)
        taskbar.setIconImage(trayIcon)
      } else {
        println("Can not load resource: tray-icon.png.")
      }
    } catch {
      case ex: AWTException => println("Filed to load tray icon.")
      case ex: UnsupportedOperationException => println("The os does not support: 'taskbar.setIconImage'")
      case ex: SecurityException => println("There was a security exception for: 'taskbar.setIconImage'")
      case ex => println(ex.toString)
    }
  }
}
