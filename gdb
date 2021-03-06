gdb ./hello
(gdb) info functions                    shows programs function
(gdb) break *main                       set breakpoint to main function
(gdb) run                               run program
(gdb) disassemble main                   to disassemble main 
(gdb) set disassembly-flavor intel      changes assembly view to intel appose to linux default att
(gdb) break *0x0909090909               set breakpoint at memory address 0x0909090909
(gdb) continue                          continue program execution
(gdb) disassemble                       disassemble code '=>' will point to next instruction that will be executed
(gdb) info registers                    view Registers
(gdb) ni                                execute next intruction
(gdb) print $eflags                     will print EFLAGS register
(gdb) set $eax=0                        set EA register to 0 
(gdb) set $eip=0x7857486547             set Instruction Pointer to bypass a logical jump
(gdb) x/-8s $ebp                        examine vars that are stored in reference to Base Pointer by the last 8s-can use (- or +)
(gdb) x/s 0x7fffffffe030                #info registers -> $rax has value "0x7fffffffe030" THIS CMD wiil read whats in the value stored at this address
(gdb) print $rax | info register $rax | info register   print registers

 NOTE : strace    used to intercept the System calls that is called by a process and records the signals received by a process 
        ltrace    used to intercept and record the Dynamic Library calls which are called by the executing process and the signals which are reieved by the process 
        
        ltrace ./hello   || strace ./hello


elf main
exe entry
-------------------
0 x 1 = 0
1 x 16 = 16
1 x 16 x 16 = 256
0 x 16 x 16 x 16 = 0

0 + 16 + 256 + 0 = 272

That is all there is to it. Here is the answer to 0X0110 in decimal:

272
