# Encryption-decryption
A simple encryption/decryption tool written in java.

Current stage: 5/6.

## Links
[https://hyperskill.org/projects/46?goal=7](https://hyperskill.org/projects/46?goal=7)

## Installation
Just run the Main.class

## Keywords
You can use the following keywords to encrypt/decrypt text data:

| Keyword       | -
| ------------- |:-------------
| -key          |number from 0-2³¹-1 for shifting each character
| -mode         |enc for encryption or dec for decryption
| -data         |text to be encrypted/decrypted
| -in           |path to file to be encrypted/decrypted
| -out          |filename in which the encrypted/decrypted text is written

## Usage examples
##### Example1
input:
`java Main -data encryptme -key 9`

expected output:
`nwl{?y}vn`

##### Example2
input:
`java Main -data encryptme -key 9 -mode dec`

expected output:
`encryptme`

##### Example3
input:
`java Main -data encryptme -key 9 -mode dec -out exampleFile.txt`

expected output:
inside created exampleFile.txt: `encryptme`

