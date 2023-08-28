module Region ( Region, newR, foundR, citiesR, tunelR, pathR , linksR, linkR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR)
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

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región, buscando una ruta, mediante tuneles, que las conecte. por ejemplo A -> B, B->C , el tunel conecta a A con C.
tunelR (Reg cs ls ts) [c1, c2] = Reg cs ls (newT(pathR (Reg cs ls ts) c1 c2):ts) 

pathR :: Region -> City -> City -> [Link] -- indica el camino de enlaces que hay que recorrer para ir de una ciudad a otra. por ejemplo A -> B, B->C , el tunel conecta a A con C.
pathR (Reg cs ls _) c1 c2 | c1 == c2 = []
                          | actuallylinkedR (Reg cs ls ts) c1 c2 = findPath nonFullLinks (Reg cs ls ts)
                          | otherwise = error "Las ciudades nombradas no se encuentran enlazadas"

findPath :: [Link] -> [Link]
findPath = -- codigo para encontrar los links que vayan de A a D cuando una lista es por ejemplo [[A,B,q],[B,C,q],[B,D,q]] (daria [[A,B,q],[B,D,q]])
-- deberia ser una lista ordenada? si tunelR genera un tunel entre dos ciudades con newT supongo que newT requiere una lista ordenada

--
-- hecho: pathR toma la region y la ciudad inicial y final que quiero llegar.
--        primero se tiene que fijar si la ciudad inicial y la ciudad final se encuentran en la region.
-- hecho: si ambas son la misma ciudad devuelve una lista vacia
-- hecho: se fija si ambas estan linkeadas con linkedR, ignorando los links llenos
--        findPath encuentra los links que utilizar en la nueva lista sin links llenos y los devuelve como lista de links
--        a cada link de la lista le gasta 1 de capacidad
--

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
nonFullLinks (Reg cs ls ts) = (\link -> availableCapacityForR (Reg cs ls ts)  c2 > 0) ls
 -- deberia tomar la lista de los links de la region, chequear cada link contra los tuneles hechos si tiene espacio, y si no esta lleno pasarlo a una nueva lista

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cs ls ts) c1 c2 = delayT (head (filter (\t -> connectsT c1 c2 t) ts))

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cs ls ts) c1 c2 = capacityL (head (filter (\l -> linksL c1 c2 l) ls))

usedCapacityForR :: Region -> City -> City -> Int -- indica la capacidad utilizada entre dos ciudades
usedCapacityForR (Reg cs ls ts) c1 c2 = length ts