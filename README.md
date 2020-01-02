# Encryption-decryption
A simple encryption/decryption tool written in java.

Current stage: 5/6.

## Links
[https://hyperskill.org/projects/46?goal=7](https://hyperskill.org/projects/46?goal=7)

## Installation
Just run the Main.class

## Keywords
You can use the following keywords to encrypt/decrypt text data:

-key  [number from 0-2³¹-1 for shifting the current character]

-mode [enc for encryption or dec for decryption]

-data [text to be encrypted/decrypted]

-in   [path to file to be encrypted/decrypted]

-out  [filename in which the encrypted/decrypted text is written]


## Usage example
input:

java Main -data encryptme -key 9

output:

nwl{?y}vn




input:

java Main -data encryptme -key 9 -mode dec

output:

encryptme

