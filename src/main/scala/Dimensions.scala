/**
  * Created by fj on 11/02/17.
  */

import scala.util.parsing.json._

object Dimensions extends App {
  sealed trait PackType
  case object Fun extends PackType
  case object Team extends PackType
  case object Level extends PackType
  case object Story extends PackType
  case object Polybag extends PackType

  val adventureWorlds = List("DCComics",
    "LEGOMovie",
    "LordOfTheRings",
    "WizardOfOz",
    "BackToTheFuture",
    "Portal2",
    "DoctorWho",
    "Ninjago",
    "TheSimpsons",
    "ScoobyDoo",
    "LegendsOfChima",
    "JurrasicWorld",
    "GhostBusters",
    "MidwayArcade",
    "AdventureTime",
    "HarryPotter",
    "TheATeam",
    "SonicTheHedgehog",
    "Ghostbusters2016",
    "ET",
    "MissionImpossible",
    "FantasticBeastsAndWhereToFindThem",
    "Gremlins",
    "TeenTitansGo",
    "TheGoonies",
    "KnightRider",
    "LegoCityUndercover",
    "BeetleJuice",
    "PowerPuffGirls",
    "TheLEGOBatmanMovie"
  )

  val levelWorlds = List("Vorton","BackToTheFuture","TheSimpsons","Portal2","DoctorWho", "GhostBusters", "MidwayArcade",
    "SonicTheHedgehog",
    "AdventureTime",
    "MissionImpossible",
    "TheGoonies"
  )
  val storyWorlds = List("Ghostbusters2016","FantasticBeastsAndWhereToFindThem","TheLEGOBatmanMovie")

  type Ability = String

  case class pack(id: Int, name: String, packType: String, world: String, abilities: List[Ability], waveTimesTen: Int = 10)

  def allAbilities(packs: List[pack]): Set[Ability] = {
    packs.flatMap(p => p.abilities).toSet
  }

  def json2pack(json: Map[String,Any]): pack = {
    pack(json.get("id").get.asInstanceOf[Double].toInt,
      json.get("name").get.asInstanceOf[String],
      json.get("packType").get.asInstanceOf[String],
      json.get("world").get.asInstanceOf[String],
      json.get("abilities").get.asInstanceOf[List[String]],
      json.get("wave").get.asInstanceOf[Double].toInt
    )
  }

  val allPacksJson = JSON.parseFull(scala.io.Source.fromFile("./src/main/resources/packs.json").getLines.mkString)
  val allPacks = allPacksJson.get.asInstanceOf[Map[Any,Any]]("packs").asInstanceOf[List[Map[String,Any]]]


  //TODO convert to
  //val allPacks = allPacksJson.get.asInstanceOf[List[Any]]//("packs")
  println(allPacks.head)
  println(json2pack(allPacks.head))


}

class Dimensions {

}
