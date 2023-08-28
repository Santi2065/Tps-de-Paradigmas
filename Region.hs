module Region ( Region, newR, foundR, citiesR, tunelR, pathR , linksR, linkR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR, actuallyLinkedR, nonFullLinks, hasCapacity, findLink, getLinksForTunnel, findPath, getNextCity)
   where

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

findLink :: [Link] -> City -> City -> Link
findLink [] city1 city2 = error "el link no existe"
findLink (link:links) city1 city2
  | linksL city1 city2 link = link
  | otherwise = findLink links city1 city2

getLinksForTunnel :: [Link] -> [City] -> [Link]
getLinksForTunnel links (city:cities)
  | length (city:cities) == 1 = []
  | otherwise = findLink links city (head cities) : getLinksForTunnel links cities

hasCapacity :: Region -> [City] -> Bool
hasCapacity (Reg regionCities links tunnels) (city:cities)
  | length (city:cities) == 1 = True
  | availableCapacityForR (Reg regionCities links tunnels) city (head cities) > 0 =
    hasCapacity (Reg regionCities links tunnels) cities
  | otherwise = error "no hay mas capacidad"

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg regionCities links tunnels) (city:cities) | length (city:cities) == 1 = error "necesitas al menos 2 ciudades"
                                                      | hasCapacity (Reg regionCities links tunnels) (city:cities) = Reg regionCities links (tunnels ++ [newT (getLinksForTunnel links (city:cities))])
                                                      | otherwise = error "no se pudo crear el tunel"

pathR :: Region -> City -> City -> [Link]
pathR region@(Reg cs ls ts) c1 c2
  | c1 == c2 = []
  | linkedR region c1 c2 = findPath region c1 c2 [] []
  | otherwise = error "las ciudades no estan linkeadas"

findPath :: Region -> City -> City -> [City] -> [Link] -> [Link]
findPath region@(Reg cs ls _) c1 c2 visited path =
    case linksForR region c1 of
        [] -> []
        (l:restLinks) ->
            if linksL c1 c2 l && availableCapacityForR region c1 c2 > 0
                then reverse (l:path)
                else exploreNextCities region l restLinks visited path c1 c2

exploreNextCities :: Region -> Link -> [Link] -> [City] -> [Link] -> City -> City -> [Link]
exploreNextCities _ _ [] _ _ _ _ = []
exploreNextCities region l (nextLink:restLinks) visited path c1 c2
    | nextCity `elem` visited = exploreNextCities region l restLinks visited path c1 c2
    | otherwise =
        let newPath = reverse path ++ [l]
            foundPath = findPath region nextCity c2 (c1 : visited) newPath
        in if null foundPath
            then exploreNextCities region l restLinks visited path c1 c2
            else foundPath
  where
    nextCity = getNextCity region l c1

getNextCity :: Region -> Link -> City -> City
getNextCity (Reg cs _ _) l c1 = if nameC city1 == nameC c1 then city2 else city1
  where
    city1 = head [c | c <- cs, connectsL c l]
    city2 = head [c | c <- cs, connectsL c l, c /= city1]


linksForR :: Region -> City -> [Link] -- indica los enlaces que salen de una ciudad
linksForR (Reg cs ls ts) c = filter (\l -> connectsL c l) ls

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cs ls ts) c1 c2 = any (\t -> connectsT c1 c2 t) ts

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cs ls ts) c1 c2 = any (\l -> linksL c1 c2 l) ls

actuallyLinkedR :: Region -> City -> City -> Bool
actuallyLinkedR (Reg _ ls _) c1 c2 =
    any (\link -> linksL c1 c2 link && availableCapacityForR (Reg [] [] []) c1 c2 > 0) ls

nonFullLinks :: Region -> [Link]
nonFullLinks (Reg cs ls ts) = filter (\l -> availableCapacityForR (Reg cs ls ts) (city1 l) (city2 l) > 0) ls
  where
    city1 l = head [c | c <- cs, connectsL c l]
    city2 l = head [c | c <- cs, connectsL c l, c /= city1 l]
 -- deberia tomar la lista de los links de la region, chequear cada link contra los tuneles hechos si tiene espacio, y si no esta lleno pasarlo a una nueva lista

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cs ls ts) c1 c2 = delayT (head (filter (\t -> connectsT c1 c2 t) ts))

availableCapacityForR :: Region -> City -> City -> Int -- indicates the available capacity between two cities
availableCapacityForR region@(Reg cs ls ts) city1 city2
  | notElem city1 cs || notElem city2 cs = error "algunas de las ciudades no pertenece a la region"
  | otherwise =
    let link = findLink ls city1 city2
     in capacityL link - usedCapacityForR region city1 city2


usedCapacityForR :: Region -> City -> City -> Int -- indica la capacidad utilizada entre dos ciudades
usedCapacityForR (Reg cs ls ts) c1 c2 = length ts