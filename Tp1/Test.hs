-- debe descargar el modulo Test.HUnit para poder ejecutarlo corriendo el comando cabal install HUnit
-- luego ejecutar el comando runhaskell Test.hs
import Test.HUnit
import City
import Link
import Tunel
import Point
import Quality
import Region


testdifP :: Test
testdifP = "difP" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
  assertEqual "Debería ser 5" 5 (difP p1 p2)

testDistanceC :: Test
testDistanceC = "distanceC" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
  assertEqual "Debería ser 5" 5 (distanceC c1 c2)

testnameC :: Test
testnameC = "nameC" ~: do
  let p1 = newP 0 0
      c1 = newC "Ciudad1" p1
  assertEqual "Debería ser Ciudad1" "Ciudad1" (nameC c1)

testconnectsL :: Test
testconnectsL = "connectsL" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
      l = newL c1 c2 q
  assertBool "Debería estar conectada" (connectsL c1 l)
  assertBool "No debería estar conectada" (not (connectsL c1 (newL c2 c2 q)))
  
testLinksL :: Test
testLinksL = "linksL" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
      l = newL c1 c2 q
  assertBool "Debería estar conectada" (linksL c1 c2 l)
  assertBool "No debería estar conectada" (not (linksL c1 c1 l))

testcapacityL :: Test
testcapacityL = "capacityL" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
      l = newL c1 c2 q
  assertEqual "Debería ser 10" 10 (capacityL l)

testDelayL :: Test
testDelayL = "delayL" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
      l = newL c1 c2 q
  assertEqual "Debería ser 0.5" 0.5 (delayL l)

testcapacityQ :: Test
testcapacityQ = "capacityQ" ~: do
  let q = newQ "Calidad1" 10 0.5
  assertEqual "Debería ser 10" 10 (capacityQ q)

testdelayQ :: Test
testdelayQ = "delayQ" ~: do
  let q = newQ "Calidad1" 10 0.5
  assertEqual "Debería ser 0.5" 0.5 (delayQ q)

testConnectsT :: Test
testConnectsT = "connectsT" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
      l = newL c1 c2 q
      t = newT [l]
  assertBool "Debería estar conectada" (connectsT c1 c2 t)
  assertBool "No debería estar conectada" (not (connectsT c1 c1 t))

testUsesT :: Test
testUsesT = "usesT" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
      l = newL c1 c2 q
      t = newT [l]
  assertBool "Debería usar el enlace" (usesT l t)
  assertBool "No debería usar el enlace" (not (usesT (newL c1 c1 q) t))

testDelayT :: Test
testDelayT = "delayT" ~: do
  let p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q1 = newQ "Calidad1" 10 0.5
      q2 = newQ "Calidad2" 20 1.0
      l1 = newL c1 c2 q1
      l2 = newL c2 c1 q2
      t = newT [l1, l2]
  assertEqual "Debería ser 1.5" 1.5 (delayT t)

testfoundR :: Test
testfoundR = "foundR" ~: do
  let r = newR
      p1 = newP 0 0
      c1 = newC "Ciudad1" p1
  assertEqual "Debería tener una ciudad" [c1] (citiesR (foundR r c1))

testlinkR :: Test
testlinkR = "linkR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q = newQ "Calidad1" 10 0.5
  assertEqual "Debería tener un enlace" [newL c1 c2 q] (linksR (linkR r c1 c2 q))

testlinksForR :: Test
testlinksForR = "linksForR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      p3 = newP 5 6
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      c3 = newC "Ciudad3" p3
      q = newQ "Calidad1" 10 0.5
  assertEqual "Debería tener un enlace" [newL c1 c2 q] (linksForR (linkR r c1 c2 q) c1)
  assertEqual "Debería tener dos enlaces" [newL c1 c2 q, newL c1 c3 q] (linksForR (linkR (linkR r c1 c3 q) c1 c2 q) c1)


testconnectedR :: Test
testconnectedR = "connectedR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      p3 = newP 5 6
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      c3 = newC "Ciudad3" p3
      q = newQ "Calidad1" 10 0.5
      l1 = newL c1 c2 q
      l2 = newL c2 c3 q
      t = newT [l1, l2]
      region = tunelR (linkR (linkR (foundR (foundR (foundR newR c1) c2) c3) c1 c2 q) c2 c3 q) [c1, c2, c3]
      
  assertBool "Debería estar conectada" (connectedR region c1 c3)


testlinkedR :: Test
testlinkedR = "linkedR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      p3 = newP 5 6
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      c3 = newC "Ciudad3" p3
      q = newQ "Calidad1" 10 0.5
  assertBool "Debería estar enlazada" (linkedR (linkR (linkR r c1 c2 q) c1 c3 q) c1 c3)


testdelayR :: Test
testdelayR = "delayR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      p3 = newP 5 6
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      c3 = newC "Ciudad3" p3
      q1 = newQ "Calidad1" 10 0.5
      q2 = newQ "Calidad2" 20 1.0
      l1 = newL c1 c2 q1
      l2 = newL c2 c3 q2
      t = newT [l1, l2]
      region = tunelR (linkR (linkR (foundR (foundR (foundR newR c1) c2) c3) c1 c2 q1) c2 c3 q2) [c1, c2, c3]
  assertEqual "Debería ser 1.5" 1.5 (delayR region c1 c3)


testavailableCapacityForR :: Test
testavailableCapacityForR = "availableCapacityForR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      p3 = newP 5 6
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      q1 = newQ "Calidad1" 10 0.5
      region = tunelR ((linkR (foundR (foundR newR c1) c2) c1 c2 q1)) [c1, c2]
  assertEqual "Debería ser 9" 9 (availableCapacityForR region c1 c2)


testusedCapacityForR :: Test
testusedCapacityForR = "usedCapacityForR" ~: do
  let r = newR
      p1 = newP 0 0
      p2 = newP 3 4
      p3 = newP 5 6
      c1 = newC "Ciudad1" p1
      c2 = newC "Ciudad2" p2
      c3 = newC "Ciudad3" p3
      q1 = newQ "Calidad1" 10 0.5
      q2 = newQ "Calidad2" 20 1.0
      l1 = newL c1 c2 q1
      l2 = newL c2 c3 q2
      t = newT [l1, l2]
      region = tunelR (linkR (linkR (foundR (foundR (foundR newR c1) c2) c3) c1 c2 q1) c2 c3 q2) [c1, c2, c3]
  assertEqual "Debería ser 1" 1 (usedCapacityForR region c1 c3)


main :: IO Counts
main = runTestTT $ test [
  testdifP,
  testDistanceC,
  testnameC,
  testconnectsL,
  testLinksL,
  testcapacityL,
  testDelayL,
  testcapacityQ,
  testdelayQ,
  testConnectsT,
  testUsesT,
  testDelayT,
  testfoundR,
  testlinkR,
  testlinksForR,
  testlinkedR,
  testavailableCapacityForR,
  testusedCapacityForR,
  testconnectedR,
  testdelayR
  ]