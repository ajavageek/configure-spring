import ch.frankel.blog.Person

beans {
    john Person, 'John Doe'
    jane Person, 'Jane Doe', john
}

