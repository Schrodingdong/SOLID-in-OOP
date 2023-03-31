# Simple data fetcher in JAVA
This repo has 2 implementation of a data fetcher, mapper, and file writer :
- A naive implementation
- A more thought of implementation

## Naive implementation
Many problems arise in this implementation, mainly :
- Not separating Logical & State module
- Hardcoded values
- Very specific code that does a very specific task
- No abstraction
- Not following the SRP and OCP

## Second implementation
We tried to solve all of the above, for that we :
- Use Interfaces & Generics for abstracting the code as much as possible
- Followed the ISP, RSP, OCP
- Logic modules shouldn't hold any type of state