package rs.dxt.ottimale

import java.io.IOException
import java.net.URL

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLView, NoDependencyResolver}

object OttimaleApp extends JFXApp {
  val resource: URL = getClass.getResource("/app.fxml")
  if (resource == null) {
    throw new IOException("Can not load resource: app.fxml.")
  }

  //  val loader = new FXMLLoader(resource, NoDependencyResolver)
  //  loader.load
  //  val root: Parent = loader.getRoot[Parent]

  SysTray.init()

  val root = FXMLView(resource, NoDependencyResolver)
  stage = new PrimaryStage {
    title = "Ottimale"
    scene = new Scene(root)
  }
}
