package queue.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import queue.queue.Queue;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new EmptyQueue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( new EmptyQueue().add( "Something" ).isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", new EmptyQueue().add( "Something" ).head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = new EmptyQueue().add( "Something" );
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = new EmptyQueue();
    String addedObject = "Something";
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = new EmptyQueue();
    String firstAddedObject = "First";
    String secondAddedObject = "Second";

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new EmptyQueue();
    String firstAddedObject = "First";

    queue.add( firstAddedObject );
    queue.add( "Second" );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = new EmptyQueue();
    queue.add( "Something" );
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new EmptyQueue().add( "First" ).add( "Second" ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new EmptyQueue();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = new EmptyQueue();
    queue.add( "Something" );
    queue.take();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new EmptyQueue();
    try {
      queue.head();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }
}