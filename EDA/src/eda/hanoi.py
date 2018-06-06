def hanoi(n, A, B, C):
    if (n >= 1):
        hanoi( n - 1, A, C, B)
        print("Move o disco %d da haste %s para a haste %s" %(n, A, C))
        hanoi( n - 1, B, A, C)

altura = int(raw_input())
hanoi(altura, "A", "B", "C")
