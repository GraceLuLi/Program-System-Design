#include <iostream>
#include <vector>

using namespace std;

vector<int> readVals();
void printVals(vector<int> v);

int main() {
  vector<int> v = readVals();
  printVals(v);
}

vector<int> readVals(){
  int val;
  vector<int> v;
  
  while (cin >> val){
    v.push_back(val);
  }
  return v;
}

void printVals(vector<int> v){
 
  for (int i = 0; i < v.size(); i++){
    cout << v[i] << " ";
   }
}
