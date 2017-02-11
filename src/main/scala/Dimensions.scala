/**
  * Created by fj on 11/02/17.
  */
object Dimensions extends App {
  sealed trait PackType
  case object Fun extends PackType
  case object Team extends PackType
  case object Level extends PackType
  case object Story extends PackType

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

  case class pack(id: Int, name: String, packType: PackType, world: String, abilities: List[Ability])

  println("OHAI LEL")
}

class Dimensions {

}
