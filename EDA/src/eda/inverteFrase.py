frase = raw_input()

pilha =[]
palavra = ""
for letra in frase:
    if letra != " ":
        palavra += letra
    else:
        pilha.append(palavra)
        palavra = ""

fraseInvertida = ""
if palavra != "":
    fraseInvertida = palavra
    for i in range(len(pilha)):
        fraseInvertida += " " +  pilha.pop()
print(fraseInvertida)
