parenteses = raw_input()
pilha = []
valid = True

for parentese in parenteses:
    if parentese == "(":
        pilha.append("(")
    elif parentese == ")":
        if len(pilha) == 0:
            valid = False
        else:
            pilha.pop()

if valid and len(pilha) == 0:
    print("S")
else:
    print("N")
