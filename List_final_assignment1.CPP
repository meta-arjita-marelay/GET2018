#include<iostream.h>
#include<conio.h>
#include<string.h>
//implementation with linked list
struct list{
int data;
list *next;
};
class linklist{
private:
list * head;
public:
linklist()
{
head=NULL;
}
void push(int el)
{
list *temp= NULL;
list * nlist = new list;
nlist->data=el;
nlist->next=NULL;
temp=head;
head=nlist;
nlist->next=temp;
}
void pop()
{
if(head==NULL)
cout<<endl<<"Sorry!! Stack is already empty.";
else{
list *temp=NULL;
temp=head;
head=head->next;
int element =temp->data;
delete(temp);
cout<<endl<<"Popped element is: "<<element;
}
}
void isempty()
{
if(head==NULL)
cout<<endl<<"Empty stack";
else
cout<<endl<<"Not empty stack";
}
void top()
{
if(head==NULL)
cout<<endl<<"Sorry!! Stack is already empty.";
else
{
cout<<endl<<"Top element is: "<<head->data;
}
}
};

void link_imp()
{
linklist l1;
int ch,el,ch1;
do{
cout<<endl<<"Enter your choice :"<<endl<<"1.Push"<<endl<<"2.Pop"<<endl<<"3.Top element"<<endl<<"4.Check if empty";
cin>>ch;
switch(ch){
case 1:
cout<<endl<<"Enter number.";
cin>>el;
l1.push(el);
break;
case 2:
l1.pop();
break;
case 3:
l1.top();
break;
case 4:
l1.isempty();
break;
default:
cout<<endl<<"Enter right choice.";
}
cout<<endl<<"Want to enter more?(1....for yes)";
cin>>ch1;
}while(ch1==1);
}

//array implementation
int top=-1;
int arr[20];
void push ()
{
int element;
if(top==19)
cout<<endl<<"Stack overflow";
else{
cout<<endl<<"Enter a number.";
cin>>element;
top++;
arr[top]=element;
}
}
void pop()
{
if(top==-1)
cout<<endl<<"stack already empty.";
else
{
cout<<endl<<"Popped element: "<<arr[top];
top--;
}
}

void array_imp()
{
int ch,ch1,element;

do{
cout<<endl<<"Enter your choice :"<<endl<<"1.Push"<<endl<<"2.Pop"<<endl<<"3.Top element"<<endl<<"4.Check if empty";
cin>>ch;
switch (ch)
{
case 1:
push();
break;
case 2:
pop();
break;
case 3:
if(top==-1)
cout<<endl<<"Stack empty";
else
cout<<endl<<"Stack not empty";
break;
case 4:
if(top==-1)
cout<<endl<<"Stack empty";
else
cout<<endl<<"Top element: "<<arr[top];
break;
default:
cout<<endl<<"Enter right choice";
}
cout<<endl<<"Want to enter more? (1...for yes)";
cin>>ch1;
}while(ch1==1);

}

//checking palindrome
void checkpalin()
{
char str1[6],str2[6];
int top=-1;
cout<<endl<<"Enter string.";
while(top<6)
{
top++;
str1[top]=getch();
cout<<str1[top];
}
for(int i=0; i<6; i++)
{
str2[i]=str1[top];
top--;
}

if(strcmp(str2,str1))
cout<<endl<<"Palindrome.";
else
cout<<endl<<"Not a palindrome.";
top=-1;
}


void main()
{
clrscr();
int choice;
cout<<"Enter your choice."<<endl<<"1.....array implementation of stack."<<endl<<"2....linked list implementation of stack."<<endl<<"3....Check palindrome.";
cin>>choice;
switch (choice)
{
case 1:
array_imp();
break;
case 2:
link_imp();
break;
case 3:
checkpalin();
break;
default:
cout<<endl<<"Enter right choice";
}
getch();
}


