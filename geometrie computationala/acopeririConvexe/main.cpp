#include <iostream>
#include <cmath>
#include <bits/stdc++.h>
using namespace std;
struct punct{
    double x,y;
};
double arie (punct a, punct b, punct c){
    return 0.5*abs(a.x*b.y + b.x*c.y + a.y*c.x - b.y*c.x - a.y*b.x - c.y*a.x);
}
bool coliniare (punct a, punct b, punct c , punct d){
    if( (c.x-a.x)*(b.y-a.y) != (b.x-a.x)*(c.y-a.y) ) //testeaza daca punctul nu C trece prin dreapta AB
        return 0;
    if( (d.x-a.x)*(b.y-a.y) != (b.x-a.x)*(d.y-a.y) ) //testeaza daca punctul nu D trece prin dreapta AB
        return 0;
    return 1;
}
bool howToSort(punct a,punct b){
    if(a.x==b.x)
        return (a.y>b.y);
    return (a.x>b.x);
}
void seg(punct a, punct b, punct c, punct d){
    vector<punct> v;
    v.push_back(a),
    v.push_back(b);
    v.push_back(c);
    v.push_back(d);
    sort(v.begin(),v.end(),howToSort);
    cout<<"Multimile sunt:"<<endl<<"{("<<v[0].x<<", "<<v[0].y<<")"<<", ("<<v[3].x<<", "<<v[3].y<<")}"<<endl;
    cout<<"{("<<v[1].x<<", "<<v[1].y<<")"<<", ("<<v[2].x<<", "<<v[2].y<<")}";
}
void triunghi(punct a,punct b,punct c,punct p){
    cout<<"Multimile sunt:"<<endl<<"{("<<p.x<<", "<<p.y<<")}";
    cout<<endl<<"{("<<a.x<<", "<<a.y<<")"<<", ("<<b.x<<", "<<b.y<<"), ("<<c.x<<", "<<c.y<<")}";
}
int testOrientare(punct a,punct b,punct c) {
    return b.x*c.y+a.x*b.y+a.y*c.x-a.y*b.x-b.y*c.x-a.x*c.y;
}
void patrulater(punct a,punct b,punct c,punct d){
    if(testOrientare(a,b,c)*testOrientare(a,b,d) < 0){   //adica C si D sunt in st si in dr lui AB
        cout<<"Multimile sunt:"<<endl<<"{("<<a.x<<", "<<a.y<<")"<<", ("<<b.x<<", "<<b.y<<")}";
        cout<<endl<<"{("<<c.x<<", "<<c.y<<"), ("<<d.x<<", "<<d.y<<")}";
    }
    if(testOrientare(a,c,b)*testOrientare(a,c,d) < 0){
        cout<<"Multimile sunt:"<<endl<<"{("<<a.x<<", "<<a.y<<")"<<", ("<<c.x<<", "<<c.y<<")}";
        cout<<endl<<"{("<<b.x<<", "<<b.y<<"), ("<<d.x<<", "<<d.y<<")}";
    }
    if(testOrientare(a,d,c)*testOrientare(a,d,b) < 0){
        cout<<"Multimile sunt:"<<endl<<"{("<<a.x<<", "<<a.y<<")"<<", ("<<d.x<<", "<<d.y<<")}";
        cout<<endl<<"{("<<b.x<<", "<<b.y<<"), ("<<c.x<<", "<<c.y<<")}";
    }
}
int main()
{
    punct a,b,c,d;
    cin >> a.x >> a.y >> b.x >> b.y >> c.x >> c.y >> d.x >> d.y;
    if( coliniare(a, b, c, d) ){
        seg(a,b,c,d);
        return 0;
    }
    double a1,a2,a3,a4;
    a1 = arie(a,b,c);
    a2 = arie(a,b,d);
    a3 = arie(a,c,d);
    a4 = arie(b,c,d);
    if(a1 == a2 + a3 + a4){
        triunghi(a,b,c,d);
        return 0;
    }
    if(a2 == a1 + a3 + a4){
        triunghi(a,b,d,c);
        return 0;
    }
    if(a3 == a1 + a2 + a4){
        triunghi(a,c,d,b);
        return 0;
    }
    if(a4 == a1 + a2 + a3){
        triunghi(b,c,d,a);
        return 0;
    }
    patrulater(a,b,c,d);
    return 0;
}
