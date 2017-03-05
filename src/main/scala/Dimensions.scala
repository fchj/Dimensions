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

  val levelWorlds = List("Vorton", "BackToTheFuture", "TheSimpsons", "Portal2", "DoctorWho", "GhostBusters", "MidwayArcade",
    "SonicTheHedgehog",
    "AdventureTime",
    "MissionImpossible",
    "TheGoonies"
  )
  val storyWorlds = List("Ghostbusters2016", "FantasticBeastsAndWhereToFindThem", "TheLEGOBatmanMovie")

  type Ability = String
  type World = String
  type Selection = List[pack]

  case class pack(id: Int, name: String, packType: String, world: String, abilities: List[Ability], waveTimesTen: Int = 10)

  def distinctAbilities(packs: List[pack]): Set[Ability] = {
    packs.flatMap(p => p.abilities).toSet
  }

  //TODO worlds are adv, level, story etc. one function for each or perameter??
  def distinctWorlds(packs: Selection): Set[World] = {
    packs.map(p => p.world).toSet
  }

  def distinctLevelWorlds(packs: Selection): Set[World] = {
    distinctWorlds(packs.filter(p => p.packType == "level"))
  }

  def distinctStoryWorlds(packs: Selection): Set[World] = {
    distinctWorlds(packs.filter(p => p.packType == "story"))
  }

  def json2pack(json: Map[String, Any]): pack = {
    pack(json.get("id").get.asInstanceOf[Double].toInt,
      json.get("name").get.asInstanceOf[String],
      json.get("packType").get.asInstanceOf[String],
      json.get("world").get.asInstanceOf[String],
      json.get("abilities").get.asInstanceOf[List[String]],
      json.get("wave").get.asInstanceOf[Double].toInt
    )
  }

  val allPacksJson = JSON.parseFull(scala.io.Source.fromFile("./src/main/resources/packs.json").getLines.mkString)
  val allPacksAny = allPacksJson.get.asInstanceOf[Map[Any, Any]]("packs").asInstanceOf[List[Map[String, Any]]]

  val allPacks = allPacksAny.map(ap => json2pack(ap))
  val allAbilities = distinctAbilities(allPacks)
  val allWorlds = distinctWorlds(allPacks)

  val currentIds = List(71248, 71245, 71344, 71205, 71256, 71240, 71171, 71340, 71235, 71203, 71247, 71344, 71223, 71202)

  val currentPacks: Selection = allPacks.filter(p => currentIds.contains(p.id))
  val missingAbilities = allAbilities diff distinctAbilities(currentPacks)
  println(s"missing abilities: $missingAbilities")
}
class Dimensions {

}
