# CS 305 — Software Security 🛡️

Author: Dylan P. Harmon  
Repository: https://github.com/DPHarmon/CS-305-Software-Security.git

## Overview 🎯
This repository contains coursework and exercises for CS 305 — Software Security (SNHU). It demonstrates secure coding principles, vulnerability analysis, and applied cryptography topics covered in the course: hashing, encryption, secure storage, input validation, TLS (HTTP→HTTPS), and DevSecOps awareness. Implementations and tests are written in Java (Eclipse-style project).

## Project summary 🧩
The codebase contains Java exercises and utilities that illustrate secure development patterns taught in the course, including:
- Cryptographic hashing and password verification
- Symmetric encryption utilities (AES) with proper IV/nonce handling and integrity considerations
- Key generation and examples of secure key handling
- Input validation and defensive programming
- Unit tests (JUnit) verifying correctness and expected failure modes
- Redirecting HTTP to HTTPS and configuring secure TLS connections
- Awareness of DevSecOps practices (dependency checks, static analysis, CI integration)

## Key features & implementations ✨
- Secure hashing
  - Message-digest utilities (e.g., SHA-256) and password-hashing patterns with salting and verification logic.
- Symmetric encryption (AES)
  - AES utilities implementing recommended modes and explicit IV/nonce handling and integrity verification where applicable.
- Key handling
  - Examples of secure key generation and patterns for safer key lifecycle handling (generation, use, and non-persistence in logs).
- Defensive input validation
  - Centralized validators to enforce allowlists, length limits, and format checks to reduce attack surface.
- TLS / HTTPS configuration
  - Server-side redirect from HTTP to HTTPS and TLS configuration examples (certificate usage, secure cipher suites, HSTS considerations).
- Tests
  - JUnit tests covering happy-path and negative scenarios (invalid keys, tampered ciphertext, bad inputs) to validate both correctness and robustness.

## Security practices & rationale 🔐
The implementations emphasize industry-aligned practices:
- Do not hard-code secrets in source; prefer environment/keystore-backed secrets.
- Use authenticated encryption (AEAD) when possible to provide confidentiality and integrity.
- Prefer dedicated password-hashing algorithms (Argon2/bcrypt/PBKDF2) over raw digests for credentials; include salts and appropriate work factors.
- Use `SecureRandom` for nonces and key material to avoid predictability.
- Validate inputs early and use allowlists for expected formats.
- Avoid leaking sensitive data in exceptions, logs, or stack traces.
- Validate ciphertext integrity and authenticity before using decrypted data (MACs or AEAD checks).

Rationale: these practices mitigate common vulnerabilities (weak key material, predictable nonces, insecure password storage, information leakage) and align with OWASP guidance and secure development principles.

## Tests & verification ✅
- JUnit-based tests exercise cryptographic utilities, validation logic, and failure modes.
- Test goals:
  - Correctness: encryption/decryption, hash generation/verification.
  - Robustness: handling invalid keys, tampered ciphertext, and malformed inputs.
  - Determinism in tests where needed by supplying fixed test vectors or controlled inputs.
- Run the test suite with your project build tool or Eclipse JUnit runner to confirm behavior and regression protection.

## Skills Displayed
This repository showcases applied secure-development practices learned in CS 305 — Software Security.

This codebase demonstrates practical understanding and use of:
- Cryptographic hashing and password handling (salts, verification)
- Symmetric encryption (AES with proper IV/nonce handling and integrity checks)
- Secure key generation and basic key-handling patterns
- Input validation and defensive programming
- Writing unit tests that cover happy-path and negative/failure modes
- Redirecting HTTP to HTTPS and establishing secure TLS connections
- Awareness of DevSecOps practices (dependency checks, static analysis, CI integration)

## Skills Demonstrated & Real-World Applicability
- Cryptographic Hashing & Password Handling  
  - What: Implementing salted hashes and verification for credential-like data.  
  - Real-world applicability: Enables secure credential storage and verification, reducing risk of credential theft and supporting compliance/security expectations.

- Symmetric Encryption & AEAD Principles  
  - What: Using AES with correct IV/nonce handling and integrity verification.  
  - Real-world applicability: Protects sensitive data at rest/in transit—critical for services handling PII, secrets, or regulated data.

- Key Generation & Secret Handling  
  - What: Generating cryptographic keys securely and avoiding insecure persistence/logging of secrets.  
  - Real-world applicability: Prepares integration with KMS/Vault and prevents operational mistakes that commonly lead to breaches.

- Input Validation & Defensive Programming  
  - What: Enforcing allowlists/lengths, null checks, and safe parsing to prevent invalid states.  
  - Real-world applicability: Reduces attack surface for injection and parsing vulnerabilities; signals production-readiness and lower maintenance burden.

- Unit Testing & Failure-Mode Verification  
  - What: Writing JUnit tests for both expected behavior and negative scenarios (tampering, bad inputs).  
  - Real-world applicability: Supports CI-driven quality, fewer regressions, and confidence when refactoring or deploying security-sensitive changes.

- HTTP → HTTPS Redirection & TLS Configuration  
  - What: Implementing server-side redirection from HTTP to HTTPS and configuring TLS properly (certificates, trusted CAs, secure cipher suites, and HSTS where applicable).  
  - Real-world applicability: Ensures client traffic is encrypted in transit, prevents downgrade and man-in-the-middle attacks, and meets basic security/compliance requirements for web services.

- Threat Reasoning & Risk Awareness  
  - What: Anticipating misuse and tampering scenarios and coding safeguards accordingly.  
  - Real-world applicability: Reflects ability to perform basic threat modeling and prioritize mitigations—valuable for secure design and engineering decisions.

- DevSecOps Awareness  
  - What: Familiarity with automated checks (dependency scans, static analysis) and test automation.  
  - Real-world applicability: Enables contribution to secure CI/CD pipelines and helps “shift security left” in team workflows.

- Documentation & Security Communication  
  - What: Recording rationale for security choices and known constraints.  
  - Real-world applicability: Demonstrates ability to explain trade-offs to teammates and reviewers, improving cross-functional collaboration and review quality.

## Acknowledgments 🙏
Course: CS 305 — Software Security (Southern New Hampshire University)
