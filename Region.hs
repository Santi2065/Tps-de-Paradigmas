module Region ( Region, newR, foundR, citiesR, tunelR, pathR , linksR, linkR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR)
   where
import Data.List (find)
import City
import Tunel
import Link
import Quality

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cs ls ts) c = Reg (c:cs) ls ts

citiesR :: Region -> [City] -- indica las ciudades de la región (auxiliar para testear)
citiesR (Reg cs _ _) = cs

linksR :: Region -> [Link] -- indica los enlaces de la región (auxiliar para testear)
linksR (Reg _ ls _) = ls


linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cs ls ts) c1 c2 q = Reg cs (newL c1 c2 q:ls) ts

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región, buscando una ruta, mediante tuneles, que las conecte. por ejemplo A -> B, B->C , el tunel conecta a A con C.
tunelR (Reg cs ls ts) [c1, c2] = Reg cs ls (pathR (Reg cs ls ts) [c1, c2]:ts)

pathR :: Region -> City -> City -> [Link] -- indica el camino de enlaces que hay que recorrer para ir de una ciudad a otra. por ejemplo A -> B, B->C , el tunel conecta a A con C.
pathR (Reg cs ls _) c1 c2 | c1 == c2 = []
                           | linkedR (Reg cs ls ts) c1 c2 = findPath (Reg cs ls _) c1 c2 [] []
                           | otherwise = error "Las ciudades nombradas no se encuentran enlazadas"
                  
findPath :: Region -> City -> City -> [City] -> [Link] -> [Link]
findPath region@(Reg cs ls _) c1 c2 visited path =
    case ls of
        [] -> []
        (Link from to _ : restLinks) ->
            if from == c1 && to == c2
                then reverse (path ++ [Link from to (Qua "" 0 0)])
                else exploreNextCities from restLinks

exploreNextCities :: City -> [Link] -> [Link]
exploreNextCities _ [] = []
exploreNextCities from (Link nextFrom nextTo _ : restLinks)
    | nextTo `elem` visited = exploreNextCities from restLinks
    | otherwise = 
        let newPath = reverse path ++ [Link from nextTo (Qua "" 0 0)]
            foundPath = findPath (Reg cs [] []) nextTo c2 (from : visited) newPath
        in if null foundPath
              then exploreNextCities from restLinks
              else foundPath

linksForR :: Region -> City -> [Link] -- indica los enlaces que salen de una ciudad
linksForR (Reg cs ls ts) c = filter (\l -> connectsL c l) ls

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cs ls ts) c1 c2 = any (\t -> connectsT c1 c2 t) ts

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cs ls ts) c1 c2 = any (\l -> linksL c1 c2 l) ls

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cs ls ts) c1 c2 = delayT (head (filter (\t -> connectsT c1 c2 t) ts))

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cs ls ts) c1 c2 = capacityL (head (filter (\l -> linksL c1 c2 l) ls))

usedCapacityForR :: Region -> City -> City -> Int -- indica la capacidad utilizada entre dos ciudades
usedCapacityForR (Reg cs ls ts) c1 c2 = length ts