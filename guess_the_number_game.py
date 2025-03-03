import random

n= random.randint(1,50)
guess=0
guess_list=[]

while True:
    a= int(input("Enter guess number: "))
    guess+=1
    guess_list.append(a)
    
    if(a<n):
        print("Too low")
    elif(a>n):
        print("Too High")
    else:
        print(f"\nYou guess the number in {guess} attempt")
        print(guess_list)
        break