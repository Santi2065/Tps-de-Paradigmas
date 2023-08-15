module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links = Tun Links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun [Lin]) = linksL city1 city2 (Tun [Lin])

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun [Lin]) = linksL city1 city2 link
    where
        city1 = city1L link
        city2 = city2L link

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun [Lin]) = delayL link
    where
        link = head [Lin]