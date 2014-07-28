#include <iostream>
#include <vector>

using namespace std;

vector<int> readVals();
vector<int> valsGT0(vector<int> v);
int findLast(vector<int> v, int target);
void testFindLast(vector<int> v , int target);
void printVals(vector<int> v);


int main() {
  vector<int> v1 = readVals();
  cout << "vector: " ;
  printVals(v1);
  vector<int> v2 = valsGT0(v1);
  cout << "filtered: ";
  printVals(v2);
  cout << "original vector: ";
  printVals(v1);

  testFindLast(v1, 3);
  testFindLast(v1, 4);
  testFindLast(v1, 7);
 
}

vector<int> readVals(){
  int val;
  vector<int> v;
  
  while (cin >> val){
    v.push_back(val);
  }
  return v;
}

vector<int> valsGT0(vector<int> v){
  vector<int> v2;
  for (int i=0; i<v.size();i++){
    if(v[i]>0){
    v2.push_back(v[i]);
    }
  }
  return v2;
}

int findLast(vector<int> v, int target){
  int tag = -1;
  for(int i=0; i<v.size(); i++){
    if(v[i]==target){
      tag = i;
    }
  }
  
  return tag;
}

void printVals(vector<int> v){
 
  for (int i = 0; i < v.size(); i++){
    cout << v[i] << " ";
   }
  cout << endl;
}
 
void testFindLast(vector<int> v , int target){
  cout << "find target " << target << " in vector: ";
   printVals(v);
  int a = findLast(v, target);
  if(a==-1){
    cout << "target not found" << endl;
  }
  else{
    cout << "target is in position: " << a <<endl;
  }
}
