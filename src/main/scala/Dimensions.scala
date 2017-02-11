/**
  * Created by fj on 11/02/17.
  */
object Dimensions {
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


  )

  val levelWorlds = List("Vorton","Portal2",)

  case class pack(id: Int, name: String, pt: PackType, world: String)
}

class Dimensions {

}
