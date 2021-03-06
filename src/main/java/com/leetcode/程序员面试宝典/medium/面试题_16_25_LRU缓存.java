package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2021-03-06 14:37
 */
public class 面试题_16_25_LRU缓存 {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
  }



  static
  class LRUCache {

    Node[] nodes;

    Node head;

    Node tail;

    int size;

    public LRUCache(int capacity) {
      nodes = new Node[capacity];
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.right = tail;
      tail.left = head;
    }

    public int get(int key) {
      int hashCode = Integer.hashCode(key);
      int index = hashCode % nodes.length;
      if (nodes[index] == null) {
        return -1;
      }
      Node node = nodes[index];
      while (node != null) {
        if (node.key == key) {
          Node nodeLeft = node.left;
          Node nodeRight = node.right;
          nodeLeft.right = nodeRight;
          nodeRight.left = nodeLeft;

          node.right = head.right;
          node.left = head;
          node.right.left = node;
          node.left.right = node;

          return node.value;
        }
        node = node.next;
      }
      return -1;
    }

    public void put(int key, int value) {
      Node node = new Node(key, value);
      int hashCode = Integer.hashCode(key);
      int index = hashCode % nodes.length;
      boolean keyExist = false;
      if (nodes[index] == null) {
        nodes[index] = node;
      } else {
        Node tmp = nodes[index];
        while (tmp != null) {
          if (tmp.key == key) {
            tmp.value = value;
            keyExist = true;
            node = tmp;
            break;
          }
          tmp = tmp.next;
        }
        if (tmp == null) {
          node.next = nodes[index];
          nodes[index] = node;
        }
      }

      if (keyExist) {
        Node nodeLeft = node.left;
        Node nodeRight = node.right;
        nodeLeft.right = nodeRight;
        nodeRight.left = nodeLeft;
      }
      node.right = head.right;
      node.left = head;
      node.right.left = node;
      node.left.right = node;

      if (!keyExist) {
        ++size;
      }
      if (size > nodes.length) {
        --size;
        Node removeNode = tail.left;
        hashCode = Integer.hashCode(removeNode.key);
        index = hashCode % nodes.length;
        if (nodes[index].key == removeNode.key) {
          nodes[index] = nodes[index].next;
        } else {
          Node pre = nodes[index];
          Node tmp = nodes[index].next;
          while (tmp != null) {
            if (tmp.key == removeNode.key) {
              pre.next = tmp.next;
            }
            tmp = tmp.next;
          }
        }

        Node tailLeft = tail.left;
        tail.left = null;
        tail = tailLeft;
        tail.right = null;
      }
    }


    static class Node {

      int key;

      int value;

      Node left;

      Node right;

      Node next;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }

}
