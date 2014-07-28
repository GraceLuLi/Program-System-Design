#include <iostream>
#include <vector>

using namespace std;

vector<int> readVals();
vector<int> valsGT0(vector<int> v);
void printVals(vector<int> v);


int main() {
  vector<int> v1 = readVals();
  cout << "vector:" ;
  printVals(v1);
  vector<int> v2 = valsGT0(v1);
  cout << "filtered:";
  printVals(v2);
  cout << "original vector:";
  printVals(v1);
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

void printVals(vector<int> v){
 
  for (int i = 0; i < v.size(); i++){
    cout << v[i] << " ";
   }
  cout << endl;
}
