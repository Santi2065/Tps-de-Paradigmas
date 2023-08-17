module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT ls = Tun ls

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun ls) = linksL c1 c2 (head ls)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l (Tun ls) = elem l ls

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun ls) = sum (map delayL ls)

