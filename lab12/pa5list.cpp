// Name: Lu Li
// loginid: lli619
// CS 455 Lab 12
// a program to test the linked list code necessary for a hash table chain

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// this is the same Node type and ListType from PA5 Table.cpp
struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
}

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}


typedef Node * ListType;
ListType list;

//lookup,remove,insert,numEntries,printAll,hashStats methods

int* lookup(const string &key)
{
  Node *p;
  for(p = list; p != NULL; p = p->next)
 {
    if(key == p->key) 
    {
      return &p->value;
    }
 }  
  return NULL;
}

bool remove(const string &key)
{
  Node *p;
  Node *q;
  for(p = list; p->next != NULL; p = p->next)
 {
   if(key == p->key)
     {
       q = p->next;
       delete p;
       p = q;
       return true;
     }
 }
    return false;
}

  bool insert(const string &key, int value)
 {
   Node *p = new Node(key, value, list);
   list = p;
   return true;
 }

  int numEntries()
  {
     Node *p;
     int num = 0;
     for(p = list; p->next != NULL; p = p->next)
       {
         num++;
       }
     return num;
  }

  void printAll()
    {
      Node *p;
      for(p = list; p->next != NULL; p = p->next)
      {
         cout<<"key: "<<p->key<<"| valeu: "<<p->value<<endl;
      }
    }
 
  // void hashStats(ostream &out)
  

  // do methods

  void dolookup()
  {
    string key;
    cout << "Please enter the key you want to lookup: ";
    cin >> key;
    int* p = lookup(key);
    if(p == NULL)
      {
        cout << "The key you lookup is not exist!";
      }
    else
      {
        cout << "The value is: " << *p <<endl;
      }
  }
  
  void doremove()
  {
    string key;
    cout << "Please enter the key you want to remove: ";
    cin >> key;
    bool rm = remove(key);
    
    if(rm==false)
      {
	cout << "The key you want to remove is not exist!";
      }
  }

  void doinsert()
  {
    string key;
    int value;
    cout << "Please enter the key you want to insert: ";
    cin >> key;
    cout << "Please enter the value you want to insert: ";
    cin >> value;
    insert(key,value);
  }

  void donumEntries()
  {
    int num = numEntries();
    cout << "number of entries is:" << num <<endl;
  }

int main() {
  //create new nodes
  Node *a = new Node("k1",1);
  Node *b = new Node("k2",2,a);
  Node *c = new Node("k3",3,b);
  Node *d = new Node("k4",4,c);
  Node *e = new Node("k5",5,d);
  Node *f = new Node("k6",6,e);
  list = f;
  //test the six methods
  printAll();
  dolookup();
  doinsert();
  printAll();
  doremove();
  printAll();
  donumEntries();
}
