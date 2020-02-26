#include <iostream>
#include <cmath>
#include <bits/stdc++.h>
using namespace std;
struct punct{
    double x,y;
    int seg;
};
struct ecuatie{
    double a,b,c;
};
ecuatie calcul(punct A1, punct A2){
    ecuatie aux;
    aux.a = A2.y - A1.y;
    aux.b = A1.x - A2.x;
    aux.c = A1.y * (A2.x - A1.x) - A1.x * (A2.y - A1.y);
    return aux;
}
double determinant(double a, double b, double c, double d){
    return a * d - c * b;
}
bool punctSeg(punct A, punct B, punct P)
{
    if(A.x == B.x)
        if((A.y <= P.y && P.y <= B.y ) || (B.y <= P.y && P.y <= A.y ))
            return true;
    if((A.x <= P.x && P.x <= B.x ) || (B.x <= P.x && P.x <= A.x ))
            return true;
    return false;
}
bool howToSort(punct a,punct b){
    if(a.x==b.x)
        return (a.y<b.y);
    return (a.x<b.x);
}
int main()
{
    punct A1, A2, A3, A4;
    cin >> A1.x >> A1.y >> A2.x >> A2.y >> A3.x >> A3.y >> A4.x >> A4.y;
    ecuatie x, y;
    x = calcul(A1, A2);
    y = calcul(A3, A4);
    if(determinant(x.a, x.b, y.a, y.b)){
        punct p1;
        p1.x = determinant(-x.c, x.b, -y.c, y.b) / determinant(x.a, x.b, y.a, y.b) ;
        p1.y = determinant(x.a, -x.c, y.a, -y.c) / determinant(x.a, x.b, y.a, y.b);
        if( punctSeg(A1, A2, p1) && punctSeg(A3, A4, p1) ){
            cout<< "x=" << determinant(-x.c, x.b, -y.c, y.b) / determinant(x.a, x.b, y.a, y.b);
            cout<< "Y=" << determinant(x.a, -x.c, y.a, -y.c) / determinant(x.a, x.b, y.a, y.b);
        }
        else
            cout<<"nu se intersecteaza";
    }
    else{
        A1.seg = 1;
        A2.seg = 1;
        A3.seg = 2;
        A4.seg = 2;
        vector<punct> v;
        v.push_back(A1),
        v.push_back(A2);
        v.push_back(A3);
        v.push_back(A4);
        sort(v.begin(),v.end(),howToSort);
        if(v[0].seg == v[1].seg)
            cout<< "nu se intersecteaza";
        else
            cout<< "intersectia e: [ (" << v[1].x<<", "<<v[1].y<<"), ("<< v[2].x<<", "<<v[2].y<<")]";

    }
    return 0;
}
